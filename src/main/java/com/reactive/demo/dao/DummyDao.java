package com.reactive.demo.dao;

import com.reactive.demo.dto.Foo;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

@Component
public class DummyDao {

    private static final Integer EVENT_INTERVAL = 1;

    public Flux<Foo> getDummyFlux() {
        return Flux.interval(Duration.ofSeconds(EVENT_INTERVAL))
                .map(sequence -> new Foo(UUID.randomUUID().toString(), "name_"+ LocalTime.now()));
    }
}
