package com.reactive.demo.emitter;

import com.reactive.demo.dto.Foo;
import com.reactive.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class EventEmitter {

    private final EventService eventService;

    @Autowired
    public EventEmitter(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> emitEvents() {
        return eventService.getDummyFlux();
    }
}
