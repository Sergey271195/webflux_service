package com.illuminator.request;

import java.time.LocalDate;

public class RequestParameterDtoBase {

    private final String path;
    private final LocalDate updateDate = LocalDate.now().minusDays(1);
    private final Long limit = 100_000L;
    private final String group = "day";

    private Long counterId;
    private String metrics;
    private String dimensions;


    public RequestParameterDtoBase(String path) {
        this.path = path;
    }

    public Long getCounterId() {
        return counterId;
    }

    public void setCounterId(Long counterId) {
        this.counterId = counterId;
    }

    public String getPath() {
        return path;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "RequestDto[counterId=" + counterId  +
                ", path=" + path +
                ", metrics=" + metrics +
                ", dimensions=" + dimensions +
                ", updateDate=" + updateDate + ']';
    }

    public Long getLimit() {
        return limit;
    }

    public String getGroup() {
        return group;
    }
}
