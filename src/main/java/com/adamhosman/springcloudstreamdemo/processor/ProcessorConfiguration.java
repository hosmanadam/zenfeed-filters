package com.adamhosman.springcloudstreamdemo.processor;

import com.adamhosman.springcloudstreamdemo.processor.filter.NegativityDetectionService;
import com.adamhosman.springcloudstreamdemo.processor.filter.ProfanityDetectionService;
import com.adamhosman.springcloudstreamdemo.processor.filter.SpamDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProcessorConfiguration {

    @Bean
    public Function<String, String> filter1() {
        return (message) -> message + " #filter1";
    }

    @Bean
    public Function<String, String> filter2() {
        return (message) -> message + " #filter2";
    }

    @Bean
    public Function<String, String> filter3(@Autowired SpamDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

    @Bean
    public Function<String, String> filter4(@Autowired ProfanityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

    @Bean
    public Function<String, String> filter5(@Autowired NegativityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

    @Bean
    public Function<String, String> filter6() {
        return (message) -> message + " #filter6";
    }

}
