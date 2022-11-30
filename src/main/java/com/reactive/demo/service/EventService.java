package com.reactive.demo.service;

import com.reactive.demo.dao.DummyDao;
import com.reactive.demo.dto.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventService {


    private final DummyDao dummyDao;

    @Autowired
    public EventService(DummyDao dummyDao) {
        this.dummyDao = dummyDao;
    }

    public Flux<Foo> getDummyFlux() {
        return dummyDao.getDummyFlux();
    }
}
