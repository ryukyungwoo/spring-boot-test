package com.sesac7.demo;

import com.sesac7.demo.entity.Greeting;
import com.sesac7.demo.entity.GreetingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingRepository repo;

    public GreetingController(GreetingRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<String> greeting(@RequestParam("lang") String lang) {
        return repo.findByLangCode(lang)
                .stream().findFirst()
                   .map(g -> ResponseEntity.ok(g.getMessage()))
                   .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                         .body("Greeting not found for lang=" + lang));
    }
}
