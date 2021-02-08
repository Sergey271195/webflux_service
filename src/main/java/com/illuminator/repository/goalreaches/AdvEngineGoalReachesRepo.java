package com.illuminator.repository.goalreaches;

import com.illuminator.entity.goal.AdvEngineGoalReaches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;


@Repository
public interface AdvEngineGoalReachesRepo extends CrudRepository<AdvEngineGoalReaches, Long> {
    Collection<AdvEngineGoalReaches> getByDate(LocalDate date);
}

