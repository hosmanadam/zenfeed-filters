package com.adamhosman.springcloudstreamdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerConfiguration {

    @Bean
    public Consumer<String> demoConsumer() {
        return System.out::println;
    }

}
