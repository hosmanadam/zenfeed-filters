package com.zenfeed.filters.profanity.messaging;

import com.zenfeed.filters.profanity.service.ProfanityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.TOPIC_IN;
import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.TOPIC_OUT;

@Component
public class ProfanityListener {

    private final Logger logger = LoggerFactory.getLogger(ProfanityListener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ProfanityDetectionService service;

    @KafkaListener(id = "default", topics = TOPIC_IN)
    public void consume(String message) {
        logger.info("### Incoming message: {}", message);
        String processedMessage = service.process(message);
        logger.info("### Outgoing message: {}", processedMessage);
        kafkaTemplate.send(TOPIC_OUT, processedMessage);
    }

}
