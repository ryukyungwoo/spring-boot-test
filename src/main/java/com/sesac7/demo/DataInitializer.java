package com.sesac7.demo;

import com.sesac7.demo.entity.Greeting;
import com.sesac7.demo.entity.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    public DataInitializer(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // ddl-auto:create 후에 실행됩니다
        greetingRepository.save(new Greeting("en", "Hello"));
        greetingRepository.save(new Greeting("kr", "안녕하세요"));
        greetingRepository.save(new Greeting("jp", "こんにちは"));
    }
}
