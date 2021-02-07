package com.illuminator.request;

import com.illuminator.entity.main.Counter;
import com.illuminator.entity.source.ReferralSource;
import com.illuminator.entity.source.SearchPhrase;
import com.illuminator.entity.source.SourceSuperclass;
import com.illuminator.util.DimensionProjections;

public class ViewsRequestBuilder {

    private final Counter counter;
    private final Class<? extends SourceSuperclass> source;

    private final static String nonCommercialMetrics = "ym:s:visits";
    private final static String commercialMetrics =
            nonCommercialMetrics + ",ym:s:ecommercePurchases,ym:s:productPurchasedPrice";

    public ViewsRequestBuilder(Counter counter, Class<? extends SourceSuperclass> source) {
        this.counter = counter;
        this.source = source;
    }

    public RequestParameterDtoBase buildRequestDto() {
        if (source == ReferralSource.class || source == SearchPhrase.class) {
            return buildSelectedRequest(new DrilldownRequestParameterDto());
        } return buildSelectedRequest(new ByTimeRequestParametersDto());
    }

    private RequestParameterDtoBase buildSelectedRequest(RequestParameterDtoBase requestDto) {
        requestDto.setDimensions(DimensionProjections.sourceToDimensionStringRegistry.get(source));
        requestDto.setMetrics(getMetricsForCounter());
        requestDto.setCounterId(counter.getMetrikaId());
        return requestDto;
    }

    private String getMetricsForCounter() {
        return counter.isCommercial()
                ? commercialMetrics
                : nonCommercialMetrics;
    }

}
