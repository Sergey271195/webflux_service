package com.illuminator.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ByTimeResponseDto extends ResponseDtoBase {

    private QueryDto query;
    private List<ByTimeDataEntry> data;
    private List<List<LocalDate>> time_intervals;
    private List<List<Long>> totals;

    @Override
    public String toString() {
        return "ResponseByTime {\n\t" +
                query +
                data + "\n\t" +
                "time_intervals=" + time_intervals + "\n\t" +
                "totals= " + totals + "\n}";
    }

    public List<List<Long>> getTotals() {
        return totals;
    }

    public void setTotals(List<List<Long>> totals) {
        this.totals = totals;
    }


    public QueryDto getQuery() {
        return query;
    }

    public void setQuery(QueryDto query) {
        this.query = query;
    }


    public void setData(List<ByTimeDataEntry> data) {
        this.data = data;
    }

    public List<ByTimeDataEntry> getData() {
        return data;
    }

    public List<List<LocalDate>> getTime_intervals() {
        return time_intervals;
    }

    public void setTime_intervals(List<List<LocalDate>> time_intervals) {
        this.time_intervals = time_intervals;
    }
}
