package com.zenfeed.filters.testing.loggingconsumer.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitAutoConfiguration.class)
public class RabbitConfiguration {

    static final String QUEUE_IN = "filtered.default";

    @Bean
    public Queue queueIn() {
        return new Queue(QUEUE_IN);
    }
}
