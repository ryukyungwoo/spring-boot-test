package com.sesac7.demo;

import com.sesac7.demo.entity.Greeting;
import com.sesac7.demo.entity.GreetingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final GreetingRepository greetingRepository;

    public DataInitializer(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @PostConstruct
    void make() {
        greetingRepository.save(new Greeting("en", "Hello"));
        greetingRepository.save(new Greeting("kr", "안녕하세요"));
        greetingRepository.save(new Greeting("jp", "こんにちは"));
    }
}
