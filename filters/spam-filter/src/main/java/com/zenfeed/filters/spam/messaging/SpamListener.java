package com.zenfeed.filters.spam.messaging;

import com.zenfeed.filters.spam.service.SpamDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.zenfeed.filters.spam.messaging.MessagingConfiguration.TOPIC_IN;
import static com.zenfeed.filters.spam.messaging.MessagingConfiguration.TOPIC_OUT;

@Component
public class SpamListener {

    private final Logger logger = LoggerFactory.getLogger(SpamListener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private SpamDetectionService service;

    @KafkaListener(id = "default", topics = TOPIC_IN)
    public void consume(String message) {
        logger.info("### Incoming message: {}", message);
        Optional<String> processedMessage = service.process(message);
        if (processedMessage.isPresent()) {
            logger.info("### Outgoing message: {}", processedMessage.get());
            kafkaTemplate.send(TOPIC_OUT, processedMessage.get());
        }
    }

}
