package com.adamhosman.springcloudstreamdemo.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerConfiguration {

    @Bean
    public Consumer<String> consumer() {
        return System.out::println;
    }

}
