package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvEngineRepository extends CrudRepository<AdvEngine, String> {
    Optional<AdvEngine> findByMetrikaId(String id);
}
