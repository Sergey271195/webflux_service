package com.illuminator;

import com.illuminator.entity.main.Counter;
import com.illuminator.exceptions.ErrorResponseException;
import com.illuminator.repository.CounterEagerRepository;
import com.illuminator.response.ByTimeResponseHandler;
import com.illuminator.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
public class MetrikaClient {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private CounterEagerRepository counterRepository;

    @Autowired
    private ResponseHandler responseHandler;


    public List<Counter> getRelevantCounters() {
        return counterRepository.getCountersEager();
    }

    private WebClient client;

    public MetrikaClient() {
        client = WebClient.builder()
                    .baseUrl("https://api-metrika.yandex.net/stat/v1/data")
                        .defaultHeader("Authorization", "OAuth " + System.getenv("METRIC_TOKEN"))
                            .build();
    }

    public void getStatByTimeData() {
        client.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/drilldown")
                    .queryParam("ids", "62401888")
                    .queryParam("group", "day")
                    .queryParam("metrics", "ym:s:visits")
                    .queryParam("dimensions", "ym:s:lastsignReferalSource,ym:s:datePeriodday")
                    .queryParam("date1", "2021-01-01")
                    .queryParam("date2", "2021-02-01")
                    .build()
                ).retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
                ).onStatus(HttpStatus::is5xxServerError,
                        error -> error.bodyToMono(String.class).map(body -> new ErrorResponseException(body))
                ).bodyToMono(String.class).subscribe(byTimeResponse -> {
                    System.out.println(byTimeResponse);
                    applicationContext.close();
                });
    }

    public void onApplicationEvent() {
        //getStatByTimeData();
        var relevantCounters = counterRepository.getCountersEager();
        relevantCounters.stream().limit(1)
                .map(ViewsRequestHandler::handleCounter)
                .flatMap(List::stream)
                .forEach(responseHandler::handleResponse);
    }
}
