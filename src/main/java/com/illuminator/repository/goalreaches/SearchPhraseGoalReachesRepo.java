package com.illuminator.repository.goalreaches;

import com.illuminator.entity.goal.SearchPhraseGoalReaches;
import com.illuminator.entity.goal.SocialNetworkGoalReaches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface SearchPhraseGoalReachesRepo extends CrudRepository<SearchPhraseGoalReaches, Long> {
    Collection<SearchPhraseGoalReaches> getByDate(LocalDate date);
}

