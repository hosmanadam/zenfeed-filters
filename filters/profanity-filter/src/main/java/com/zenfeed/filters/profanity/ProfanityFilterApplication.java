package com.zenfeed.filters.profanity;

import com.zenfeed.filters.profanity.service.ProfanityDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class ProfanityFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfanityFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> profanityFilter(@Autowired ProfanityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

}
