package com.illuminator.repository.source;

import com.illuminator.entity.source.SearchPhrase;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchPhraseRepository extends BaseSourceRepository<SearchPhrase, Long> {
}
