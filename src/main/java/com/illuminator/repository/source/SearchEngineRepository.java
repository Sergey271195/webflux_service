package com.illuminator.repository.source;

import com.illuminator.entity.source.SearchEngine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SearchEngineRepository extends CrudRepository<SearchEngine, String> {
    Optional<SearchEngine> findByMetrikaId(String metrikaId);
}
