package com.zenfeed.filters.negativity;

import com.zenfeed.filters.negativity.service.NegativityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class NegativityFilterApplication {

    private final Logger logger = LoggerFactory.getLogger(NegativityFilterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NegativityFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> negativityFilter(@Autowired NegativityDetectionService service) {
        return (message) -> {
            logger.info("### Incoming message: {}", message);
            String processedMessage = service.process(message);
            logger.info("### Outgoing message: {}", processedMessage);
            return processedMessage;
        };
    }

}
