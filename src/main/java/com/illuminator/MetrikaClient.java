package com.illuminator;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MetrikaClient {

    private WebClient client;

    public MetrikaClient() {
        PropertiesUtil propertiesUtil = new PropertiesUtil("./resources/metrika.properties");
        String authorization_token = propertiesUtil.getStringProperty("authorization_token");
        String baseUrl = propertiesUtil.getStringProperty("metrika_base_url");
        client = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "OAuth " + authorization_token)
                .build();
    }

    public void getStatByTimeData() {

        WebClient.ResponseSpec responseSpec = client.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/bytime")
                    .queryParam("ids", "62401888")
                    .queryParam("metrics", "ym:s:visits")
                    .queryParam("dimensions", "ym:s:lastsignSearchEngineRoot")
                    .queryParam("date1", "2021-01-01")
                    .queryParam("date2", "2021-02-01")
                    .build()
                ).retrieve();
        Mono<String> response = responseSpec.bodyToMono(String.class);
        response.subscribe(result -> System.out.println(result));
    }


}
