package com.illuminator.repository.goalreaches;

import com.illuminator.entity.goal.ReferralSourceGoalReaches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface ReferralSourceGoalReachesRepo extends CrudRepository<ReferralSourceGoalReaches, Long> {
    Collection<ReferralSourceGoalReaches> getByDate(LocalDate date);
}

