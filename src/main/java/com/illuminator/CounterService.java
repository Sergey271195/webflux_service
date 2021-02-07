package com.illuminator;

import com.illuminator.entity.main.Counter;
import com.illuminator.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    @Autowired
    private static CounterRepository counterRepository;

    public static Iterable<Counter> getRelevantCounters() {
        return counterRepository.findByRelevantTrue(Sort.by(Sort.Direction.ASC, "id"));
    }

}
