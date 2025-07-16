package com.sesac7.demo;

import com.sesac7.demo.entity.Greeting;
import com.sesac7.demo.entity.GreetingRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final GreetingRepository repo;

    public DataInitializer(GreetingRepository repo) {
        this.repo = repo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        repo.save(new Greeting("en", "Hello"));
        repo.save(new Greeting("kr", "안녕하세요"));
        repo.save(new Greeting("jp", "こんにちは"));
    }
}
