package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import com.illuminator.entity.source.ReferralSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReferralSourceRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<ReferralSource, Long> {
}
