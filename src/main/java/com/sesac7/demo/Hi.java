package com.sesac7.demo;

import com.sesac7.demo.entity.Greeting;
import com.sesac7.demo.entity.GreetingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hi {
    private final GreetingRepository greetingRepository;

    public Hi(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping
    public String hi() {
        greetingRepository.save(new Greeting("en", "Hello"));
        greetingRepository.save(new Greeting("kr", "안녕하세요"));
        greetingRepository.save(new Greeting("jp", "こんにちは"));
        return "hi";
    }
}
