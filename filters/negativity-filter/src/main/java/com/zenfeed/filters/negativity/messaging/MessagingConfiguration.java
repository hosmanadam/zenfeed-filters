package com.zenfeed.filters.negativity.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitAutoConfiguration.class)
public class MessagingConfiguration {

    public static final String QUEUE_IN = "negativityFilter.default";
    public static final String QUEUE_OUT = "filtered.default";

    @Bean
    public Queue queueIn() {
        return new Queue(QUEUE_IN);
    }

    @Bean
    public Queue queueOut() {
        return new Queue(QUEUE_OUT);
    }

}