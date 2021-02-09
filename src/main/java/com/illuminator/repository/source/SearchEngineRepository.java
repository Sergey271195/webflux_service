package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import com.illuminator.entity.source.SearchEngine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchEngineRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<SearchEngine, String> {
}
