package com.sesac7.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lang_code", nullable = false, unique = true, length = 10)
    private String langCode;

    @Column(name = "message", nullable = false)
    private String message;

    protected Greeting() { /* JPA 사용을 위한 기본 생성자 */ }

    public Greeting(String langCode, String message) {
        this.langCode = langCode;
        this.message = message;
    }

    // === getters & setters ===
    public Long getId() { return id; }
    public String getLangCode() { return langCode; }
    public void setLangCode(String langCode) { this.langCode = langCode; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
