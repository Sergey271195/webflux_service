package com.illuminator.repository.source;

import com.illuminator.entity.source.TrafficSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrafficSourceRepository extends CrudRepository<TrafficSource, String> {
    Optional<TrafficSource> findByMetrikaId(String id);
}
