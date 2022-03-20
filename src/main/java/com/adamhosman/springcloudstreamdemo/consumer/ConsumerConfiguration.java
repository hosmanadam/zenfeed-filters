package com.adamhosman.springcloudstreamdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerConfiguration {

    private final Logger logger = LoggerFactory.getLogger(ConsumerConfiguration.class);

    @Bean
    public Consumer<String> consumer() {
        return (message) -> logger.info("### Message received:\n{}", message);
    }

}
