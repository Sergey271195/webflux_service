package com.illuminator.repository.goalreaches;

import com.illuminator.entity.goal.AdvEngineGoalReaches;
import com.illuminator.entity.goal.TrafficSourceGoalReaches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface TrafficSourceGoalReachesRepo extends CrudRepository<TrafficSourceGoalReaches, Long> {
    Collection<TrafficSourceGoalReaches> getByDate(LocalDate date);
}

