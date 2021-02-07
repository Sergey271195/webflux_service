package com.illuminator.request;

import org.springframework.web.util.UriBuilder;

public class MetrikaUriBuilder {

    public static UriBuilder buildRequestUri(UriBuilder uriBuilder, RequestParameterDtoBase requestDto) {
        return uriBuilder.path(requestDto.getPath())
                .queryParam("ids", requestDto.getCounterId())
                .queryParam("metrics", requestDto.getMetrics())
                .queryParam("dimensions", requestDto.getDimensions())
                .queryParam("group", requestDto.getGroup())
                .queryParam("date1", requestDto.getUpdateDate())
                .queryParam("date2", requestDto.getUpdateDate())
                .queryParam("limit", requestDto.getLimit());
    }

}
