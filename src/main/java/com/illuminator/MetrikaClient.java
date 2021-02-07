package com.illuminator;

import com.illuminator.dto.ByTimeResponseDto;
import com.illuminator.entity.main.Counter;
import com.illuminator.entity.source.SourceSuperclass;
import com.illuminator.exceptions.ErrorResponseException;
import com.illuminator.repository.CounterEagerRepository;
import com.illuminator.request.ViewsRequestBuilder;
import com.illuminator.util.DimensionProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class MetrikaClient implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private CounterEagerRepository counterRepository;

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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //getStatByTimeData();
        var relevantCounters = counterRepository.getCountersEager();
        relevantCounters.stream().limit(1)
                .forEach(ViewsRequestHandler::handleCounter);
    }
}
