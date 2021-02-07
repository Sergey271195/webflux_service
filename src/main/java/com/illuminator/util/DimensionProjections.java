package com.illuminator.util;

import com.illuminator.entity.source.*;

import java.util.HashMap;
import java.util.Map;

public class DimensionProjections {

    public final static Map<Class<? extends SourceSuperclass>, String> sourceToDimensionStringRegistry = new HashMap<>();
    static {
        sourceToDimensionStringRegistry.put(AdvEngine.class, "ym:s:lastsignAdvEngine");
        sourceToDimensionStringRegistry.put(ReferralSource.class, "ym:s:lastsignReferalSource");
        sourceToDimensionStringRegistry.put(SearchEngine.class, "ym:s:lastsignSearchEngineRoot");
        sourceToDimensionStringRegistry.put(SearchPhrase.class, "ym:s:lastsignSearchPhrase");
        sourceToDimensionStringRegistry.put(SocialNetwork.class, "ym:s:lastsignSocialNetwork");
        sourceToDimensionStringRegistry.put(TrafficSource.class, "ym:s:lastsignTrafficSource");
    }

}
