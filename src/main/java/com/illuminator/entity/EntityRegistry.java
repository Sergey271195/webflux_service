package com.illuminator.entity;

import com.illuminator.entity.source.*;

import java.util.List;

public class EntityRegistry {

    public final static List<Class> ENTITY_SOURCE_CLASS_REGISTRY = List.of(
            AdvEngine.class,
            ReferralSource.class,
            SearchEngine.class,
            SearchPhrase.class,
            SocialNetwork.class,
            TrafficSource.class
    );

}
