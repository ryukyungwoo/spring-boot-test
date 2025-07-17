package com.sesac7.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                         // 모든 엔드포인트에 대해
                .allowedOrigins("http://localhost:3000",
                        "http://192.168.20.235:3000",
                        "http://localhost",
                        "http://192.168.20.235"
                        )   // 허용할 Origin (Next.js dev 서버)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")                       // 모든 헤더 허용
                .allowCredentials(true)                    // 쿠키/인증 헤더 허용
                .maxAge(3600);
    }
}
