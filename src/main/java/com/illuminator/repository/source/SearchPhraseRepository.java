package com.illuminator.repository.source;

import com.illuminator.entity.source.SearchPhrase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SearchPhraseRepository extends CrudRepository<SearchPhrase, Long> {
    Optional<SearchPhrase> findByMetrikaId(Long id);
}
