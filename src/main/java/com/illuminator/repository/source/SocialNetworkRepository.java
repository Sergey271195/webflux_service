package com.illuminator.repository.source;

import com.illuminator.entity.source.SocialNetwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocialNetworkRepository extends CrudRepository<SocialNetwork, String> {
    Optional<SocialNetwork> findByMetrikaId(String metrikaId);
}
