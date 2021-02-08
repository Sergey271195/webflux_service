package com.illuminator;

import com.illuminator.repository.source.AdvEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestClass {

    @Autowired
    private AdvEngineRepository advEngineRepository;

    public void test() {
        System.out.println(advEngineRepository.findByMetrikaId("google"));
    }

}
