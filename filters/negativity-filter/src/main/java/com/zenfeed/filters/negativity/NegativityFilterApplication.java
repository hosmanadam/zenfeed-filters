package com.zenfeed.filters.negativity;

import com.zenfeed.filters.negativity.service.NegativityDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class NegativityFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(NegativityFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> negativityFilter(@Autowired NegativityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

}
