package com.illuminator.repository.source;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Optional;

public interface BaseSourceRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Optional<T> findByMetrikaId(Serializable metrikaId);
}
