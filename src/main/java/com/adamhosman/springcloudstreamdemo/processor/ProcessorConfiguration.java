package com.adamhosman.springcloudstreamdemo.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ProcessorConfiguration {

    @Bean
    public Function<String, String> processor() {
        return (message) -> message + " [PROCESSED]";
    }

}
