package com.illuminator.repository;

import com.illuminator.entity.main.Counter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CounterEagerRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Counter> getCountersEager() {
        return em.createQuery("SELECT c FROM Counter AS c JOIN FETCH c.goals " +
                "WHERE c.relevant = true ORDER BY c.id DESC").getResultList();
    }

}
