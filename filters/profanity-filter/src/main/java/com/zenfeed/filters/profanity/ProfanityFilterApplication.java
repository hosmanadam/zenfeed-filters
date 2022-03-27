package com.zenfeed.filters.profanity;

import com.zenfeed.filters.profanity.service.ProfanityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class ProfanityFilterApplication {

    private final Logger logger = LoggerFactory.getLogger(ProfanityFilterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProfanityFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> profanityFilter(@Autowired ProfanityDetectionService service) {
        return (message) -> {
            logger.info("### Incoming message: {}", message);
            String processedMessage = service.process(message);
            logger.info("### Outgoing message: {}", processedMessage);
            return processedMessage;
        };
    }

}
