package com.illuminator.repository.goalreaches;

import com.illuminator.entity.goal.AdvEngineGoalReaches;
import com.illuminator.entity.goal.SearchEngineGoalReaches;
import com.illuminator.entity.goal.SocialNetworkGoalReaches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface SearchEngineGoalReachesRepo extends CrudRepository<SearchEngineGoalReaches, Long> {
    Collection<SearchEngineGoalReaches> getByDate(LocalDate date);
}

