package com.zenfeed.filters.testing.restproducer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RabbitAutoConfiguration.class)
public class MessagingConfiguration {

    public static final String QUEUE_OUT = "spamFilter.default";

    @Bean
    public Queue queueOut() {
        return new Queue(QUEUE_OUT);
    }

}
