package com.illuminator.util;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

public class ExchangeFunctionLogger {

    public static ExchangeFilterFunction logRequestUrl() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            System.out.println("[REQUEST URL]");
            System.out.println(clientRequest.url());
            return Mono.just(clientRequest);
        });
    }

}
