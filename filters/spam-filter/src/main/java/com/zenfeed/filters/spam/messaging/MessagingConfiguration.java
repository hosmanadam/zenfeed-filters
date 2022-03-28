package com.zenfeed.filters.spam.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MessagingConfiguration {

    public static final String TOPIC_IN = "spamFilter";
    public static final String TOPIC_OUT = "profanityFilter";

    @Bean
    public NewTopic topicIn() {
        return TopicBuilder.name(TOPIC_IN).build();
    }

    @Bean
    public NewTopic topicOut() {
        return TopicBuilder.name(TOPIC_OUT).build();
    }

}
