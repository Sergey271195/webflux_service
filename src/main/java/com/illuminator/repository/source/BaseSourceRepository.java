package com.illuminator.repository.source;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseSourceRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Optional<T> findByMetrikaId(Serializable metrikaId);
}
