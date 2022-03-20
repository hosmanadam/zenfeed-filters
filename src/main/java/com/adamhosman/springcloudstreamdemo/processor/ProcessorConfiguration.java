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
    public Function<String, String> filter1(@Autowired SpamDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

    @Bean
    public Function<String, String> filter2(@Autowired ProfanityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

    @Bean
    public Function<String, String> filter3(@Autowired NegativityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

}
