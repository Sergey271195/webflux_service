package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import com.illuminator.entity.source.TrafficSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficSourceRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<TrafficSource, String> {
}
