package com.illuminator;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.dto.DrilldownResponseDto;
import com.illuminator.dto.ResponseDtoBase;
import com.illuminator.entity.main.Counter;
import com.illuminator.exceptions.ErrorResponseException;
import com.illuminator.request.ByTimeRequestParametersDto;
import com.illuminator.request.MetrikaUriBuilder;
import com.illuminator.request.RequestParameterDtoBase;
import com.illuminator.request.ViewsRequestBuilder;
import com.illuminator.response.ByTimeResponseHandler;
import com.illuminator.response.DrilldownResponseHandler;
import com.illuminator.util.DimensionProjections;
import com.illuminator.util.ExchangeFunctionLogger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ViewsRequestHandler {

    private static WebClient client = setWebClient();

    public static List<ResponseDtoBase> handleCounter(Counter counter) {
        List<RequestParameterDtoBase> requestList = getRequestDto(counter);
        return requestList.stream().map(ViewsRequestHandler::handleRequestDto)
            .collect(Collectors.toList());
    }

    private static ResponseDtoBase handleRequestDto(RequestParameterDtoBase requestDto) {
        WebClient.ResponseSpec spec = client.get()
                .uri(uriBuilder ->
                        MetrikaUriBuilder.buildRequestUri(uriBuilder, requestDto).build()
                ).retrieve();
        WebClient.ResponseSpec errorHandledSpec = handleResponseSpecErrors(spec);
        if (requestDto.getClass() == ByTimeRequestParametersDto.class) {
            return handleStatDyTimeRepsonse(errorHandledSpec);
        } else {
            return handleDrilldownRepsonse(errorHandledSpec);
        }
    }

    private static WebClient.ResponseSpec handleResponseSpecErrors(WebClient.ResponseSpec specs) {
        return specs.onStatus(HttpStatus::is4xxClientError,
                error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
        ).onStatus(HttpStatus::is5xxServerError,
                error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
        );
    }

    private static ResponseDtoBase handleStatDyTimeRepsonse(WebClient.ResponseSpec specs) {
        return specs.bodyToMono(ByTimeResponseDto.class).block();
    }

    private static ResponseDtoBase handleDrilldownRepsonse(WebClient.ResponseSpec specs) {
        return specs.bodyToMono(DrilldownResponseDto.class).block();
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
