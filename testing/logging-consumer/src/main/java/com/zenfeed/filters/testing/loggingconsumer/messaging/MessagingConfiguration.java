package com.zenfeed.filters.testing.loggingconsumer.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MessagingConfiguration {

    public static final String TOPIC_IN = "filtered";

    @Bean
    public NewTopic topicIn() {
        return TopicBuilder.name(TOPIC_IN).build();
    }

}
