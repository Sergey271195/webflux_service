package com.illuminator.repository.source;

import com.illuminator.entity.source.SearchEngine;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchEngineRepository extends BaseSourceRepository<SearchEngine, String> {
}
