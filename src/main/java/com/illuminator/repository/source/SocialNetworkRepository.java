package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import com.illuminator.entity.source.SocialNetwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<SocialNetwork, String> {
}
