package com.adamhosman.springcloudstreamdemo.processor;

import com.adamhosman.springcloudstreamdemo.processor.filter.NegativityDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProcessorConfiguration {

    @Bean
    public Function<String, String> negativityFilter(@Autowired NegativityDetectionService service) {
        return (message) -> service.process(message).orElse(null);
    }

}