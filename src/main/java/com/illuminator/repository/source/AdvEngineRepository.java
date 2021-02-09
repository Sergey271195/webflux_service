package com.illuminator.repository.source;

import com.illuminator.entity.source.AdvEngine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdvEngineRepository extends CrudRepository<AdvEngine, String>, BaseSourceRepository<AdvEngine, String> {
}
