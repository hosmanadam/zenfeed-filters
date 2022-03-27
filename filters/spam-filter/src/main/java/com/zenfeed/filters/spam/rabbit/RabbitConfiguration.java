package com.zenfeed.filters.spam.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitAutoConfiguration.class)
public class RabbitConfiguration {

    static final String QUEUE_IN = "spamFilter.default";
    static final String QUEUE_OUT = "profanityFilter.default";

    @Bean
    public Queue queueIn() {
        return new Queue(QUEUE_IN);
    }

    @Bean
    public Queue queueOut() {
        return new Queue(QUEUE_OUT);
    }

}
