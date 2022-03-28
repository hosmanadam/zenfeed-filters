package com.zenfeed.filters.testing.loggingconsumer.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.testing.loggingconsumer.messaging.MessagingConfiguration.TOPIC_IN;

@Component
public class LoggingListener {

    private final Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @KafkaListener(id = "default", topics = TOPIC_IN)
    public void consume(String message) {
        logger.info("### Final message: {}", message);
    }

}
