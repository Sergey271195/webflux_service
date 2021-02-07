package com.illuminator.dto;

import java.util.List;

public class DrilldownDataEntry {

    private List<Long> metrics;
    private boolean expand;
    private DimensionResponse dimension;

    @Override
    public String toString() {
        return "\n\tDrilldownDataEntry={" + dimension + ", metrics=" + metrics + ", expand=" + expand + '}';
    }


    public List<Long> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Long> metrics) {
        this.metrics = metrics;
    }

    public void setDimension(DimensionResponse dimension) {
        this.dimension = dimension;
    }

    public DimensionResponse getDimension() {
        return this.dimension;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}
