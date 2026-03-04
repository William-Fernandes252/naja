package com.example.naja.cli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

import com.example.naja.cli.advices.CLIExceptionResolver;
import com.example.naja.interfaces.converters.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class CliConfig {
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToTargetConverter());
    }

    @Bean
    CLIExceptionResolver customExceptionResolver() {
        return new CLIExceptionResolver();
    }

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
