package com.zenfeed.filters.spam;

import com.zenfeed.filters.spam.service.SpamDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class SpamFilterApplication {

    private final Logger logger = LoggerFactory.getLogger(SpamFilterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpamFilterApplication.class, args);
    }

    @Bean
    public Function<String, String> spamFilter(@Autowired SpamDetectionService service) {
        return (message) -> {
            logger.info("### Incoming message: {}", message);
            Optional<String> processedMessage = service.process(message);
            if (processedMessage.isPresent()) {
                logger.info("### Outgoing message: {}", processedMessage.get());
                return processedMessage.get();
            }
            return null;
        };
    }

}
