package com.illuminator.repository;

import com.illuminator.entity.main.Counter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
    Iterable<Counter> findByRelevantTrue(Sort sort);

}
