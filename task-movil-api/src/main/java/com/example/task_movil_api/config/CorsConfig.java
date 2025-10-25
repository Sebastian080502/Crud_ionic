package com.example.task_movil_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${app.cors.allowed-origins:}")
    private String allowedOriginsCsv;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = allowedOriginsCsv.isBlank()
                ? new String[0]
                : allowedOriginsCsv.split("\\s*,\\s*");

        registry.addMapping("/api/**")
                .allowedOriginPatterns(origins)              // ¡OJO: patterns, no allowedOrigins!
                .allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false)                     // sin cookies/sesión ⇒ false
                .maxAge(3600);
    }
}
