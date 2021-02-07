package com.illuminator.dto;

import java.time.LocalDate;
import java.util.List;

public class DrilldownResponseDto {

    private QueryDto query;
    private List<DrilldownDataEntry> data;
    private List<Long> totals;

    @Override
    public String toString() {
        return "DrilldownResponse {\n\t" +
                query +
                data + "\n\t" +
                "totals= " + totals + "\n}";
    }

    public void setQuery(QueryDto query) {
        this.query = query;
    }

    public QueryDto getQuery() {
        return this.query;
    }

    public List<DrilldownDataEntry> getData() {
        return data;
    }

    public void setData(List<DrilldownDataEntry> data) {
        this.data = data;
    }

    public List<Long> getTotals() {
        return totals;
    }

    public void setTotals(List<Long> totals) {
        this.totals = totals;
    }

}
