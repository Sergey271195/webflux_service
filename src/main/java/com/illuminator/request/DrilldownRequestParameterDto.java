package com.illuminator.request;

public class DrilldownRequestParameterDto extends RequestParameterDtoBase {
    public DrilldownRequestParameterDto() {
        super("/drilldown");
    }
    @Override
    public void setDimensions(String dimensions) {
        super.setDimensions(dimensions + ",ym:s:datePeriodday");
    }
}
