package com.illuminator;


import com.illuminator.request.MetrikaUriBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@WebFluxTest
public class MetrikaUriBuilderTest {

    private static WebClient clientWithoutRequest;
    private static MetrikaUriBuilder metrikaUriBuilder = new MetrikaUriBuilder();

    private static ExchangeFilterFunction logHeaders(String expectedUrl) {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            try {
                String actualUrl = clientRequest.url().toString();
                System.out.println(MetrikaUriBuilder.class.getSimpleName() + "\n" + expectedUrl + "\n\tAND\n" + actualUrl);
                Assertions.assertEquals(expectedUrl, actualUrl);
                throw new IllegalStateException("Equal urls");
            } catch (AssertionFailedError err) {
                throw new IllegalStateException("Unequal urls");
            }
        });
    }

    private static void setupWebClient(String expectedUrl) {
        clientWithoutRequest = WebClient.builder()
                .baseUrl("https://api-metrika.yandex.net/stat/v1/data")
                    .defaultHeader("Authorization", "OAuth " + System.getenv("METRIC_TOKEN"))
                        .filter(logHeaders(expectedUrl))
                            .build();
    }

}
