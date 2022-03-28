package com.zenfeed.filters.testing.restproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MessagingConfiguration {

    public static final String TOPIC_OUT = "spamFilter";

    @Bean
    public NewTopic topicOut() {
        return TopicBuilder.name(TOPIC_OUT).build();
    }

}
