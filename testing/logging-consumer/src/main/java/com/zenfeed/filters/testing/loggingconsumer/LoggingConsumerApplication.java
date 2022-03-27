package com.zenfeed.filters.testing.loggingconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class LoggingConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(LoggingConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoggingConsumerApplication.class, args);
    }

    @Bean
    public Consumer<String> consumer() {
        return (message) -> logger.info("### Message received:\n{}", message);
    }

}
