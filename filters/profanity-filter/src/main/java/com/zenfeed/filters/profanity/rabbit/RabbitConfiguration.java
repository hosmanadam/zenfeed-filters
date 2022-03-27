package com.zenfeed.filters.profanity.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitAutoConfiguration.class)
public class RabbitConfiguration {

    static final String QUEUE_IN = "profanityFilter.default";
    static final String QUEUE_OUT = "negativityFilter.default";

    @Bean
    public Queue queueIn() {
        return new Queue(QUEUE_IN);
    }

    @Bean
    public Queue queueOut() {
        return new Queue(QUEUE_OUT);
    }

}
