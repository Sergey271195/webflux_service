package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import com.illuminator.entity.source.SearchPhrase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchPhraseRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<SearchPhrase, Long> {
}
