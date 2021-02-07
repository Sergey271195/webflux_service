package com.illuminator.dto;

import java.util.List;

public class ByTimeDataEntry {

    private List<DimensionResponse> dimensions;
    private List<List<Long>> metrics;

    @Override
    public String toString() {
        return "\n\tByTimeDataEntry={" + dimensions + ", " + metrics + '}';
    }

    public List<DimensionResponse> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<DimensionResponse> dimensions) {
        this.dimensions = dimensions;
    }


    public void setMetrics(List<List<Long>> metrics) {
        this.metrics = metrics;
    }

    public List<List<Long>> getMetrics() {
        return metrics;
    }
}
