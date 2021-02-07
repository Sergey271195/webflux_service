package com.illuminator;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DrilldownResponseDto;
import com.illuminator.entity.main.Counter;
import com.illuminator.exceptions.ErrorResponseException;
import com.illuminator.request.ByTimeRequestParametersDto;
import com.illuminator.request.MetrikaUriBuilder;
import com.illuminator.request.RequestParameterDtoBase;
import com.illuminator.request.ViewsRequestBuilder;
import com.illuminator.util.DimensionProjections;
import com.illuminator.util.ExchangeFunctionLogger;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

public class ViewsRequestHandler {

    private static WebClient client = setWebClient();

    public static void handleCounter(Counter counter) {
        List<RequestParameterDtoBase> requestList = getRequestDto(counter);
        requestList.stream().forEach(ViewsRequestHandler::handleRequestDto);
    }

    private static void handleRequestDto(RequestParameterDtoBase requestDto) {
        WebClient.ResponseSpec spec = client.get()
                .uri(uriBuilder ->
                        MetrikaUriBuilder.buildRequestUri(uriBuilder, requestDto).build()
                ).retrieve();
        WebClient.ResponseSpec errorHandledSpec = handleResponseSpecErrors(spec);
        if (requestDto.getClass() == ByTimeRequestParametersDto.class) {
            System.out.println("Request DTO CLASS BY TIME " + requestDto.getClass().getSimpleName());
            handleStatDyTimeRepsonse(errorHandledSpec);
        } else {
            System.out.println("Request DTO CLASS DRILLDOWN " + requestDto.getClass().getSimpleName());
            handleDrilldownRepsonse(errorHandledSpec);
        }
    }

    private static WebClient.ResponseSpec handleResponseSpecErrors(WebClient.ResponseSpec specs) {
        return specs.onStatus(HttpStatus::is4xxClientError,
                error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
        ).onStatus(HttpStatus::is5xxServerError,
                error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
        );
    }

    private static void handleStatDyTimeRepsonse(WebClient.ResponseSpec specs) {
        specs.bodyToMono(ByTimeResponseDto.class).subscribe(byTimeResponse -> {
            System.out.println("Stat by Time response");
            System.out.println(byTimeResponse);
        });
    }

    private static void handleDrilldownRepsonse(WebClient.ResponseSpec specs) {
        specs.bodyToMono(DrilldownResponseDto.class).subscribe(DrilldownResponse -> {
            System.out.println("Drilldown Repsonse");
            System.out.println(DrilldownResponse);
        });
    }

    private static List<RequestParameterDtoBase> getRequestDto(Counter counter) {
        return DimensionProjections.sourceToDimensionStringRegistry.keySet().stream()
                .map(source -> new ViewsRequestBuilder(counter, source))
                .map(ViewsRequestBuilder::buildRequestDto)
                .collect(Collectors.toList());
    }

    private static WebClient setWebClient() {
        return WebClient.builder()
                .baseUrl("https://api-metrika.yandex.net/stat/v1/data")
                .defaultHeader("Authorization", "OAuth " + System.getenv("METRIC_TOKEN"))
                .filters(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(ExchangeFunctionLogger.logRequestUrl());
                })
                .build();
    }

}
