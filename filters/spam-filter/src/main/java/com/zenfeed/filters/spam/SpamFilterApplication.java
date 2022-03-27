package com.zenfeed.filters.spam;

import com.zenfeed.filters.spam.service.SpamDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpamFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpamFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> spamFilter(@Autowired SpamDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

}
