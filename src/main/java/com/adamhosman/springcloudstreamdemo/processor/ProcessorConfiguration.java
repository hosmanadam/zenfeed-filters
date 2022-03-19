package com.adamhosman.springcloudstreamdemo.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
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
    public Function<String, String> filter3() {
        return (message) -> message + " #filter3";
    }

    @Bean
    public Function<String, String> filter4() {
        return (message) -> message + " #filter4";
    }

    @Bean
    public Function<String, String> filter5() {
        return (message) -> message + " #filter5";
    }

    @Bean
    public Function<String, String> filter6() {
        return (message) -> message + " #filter6";
    }

}
