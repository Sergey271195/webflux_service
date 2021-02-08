package com.illuminator.repository.source;

import com.illuminator.entity.source.ReferralSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferralSourceRepository extends CrudRepository<ReferralSource, Long> {
    Optional<ReferralSource> findByMetrikaId(Long id);
}
