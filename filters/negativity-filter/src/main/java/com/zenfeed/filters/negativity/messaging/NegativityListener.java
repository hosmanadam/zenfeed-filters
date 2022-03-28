package com.zenfeed.filters.negativity.messaging;

import com.zenfeed.filters.negativity.service.NegativityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.negativity.messaging.MessagingConfiguration.TOPIC_IN;
import static com.zenfeed.filters.negativity.messaging.MessagingConfiguration.TOPIC_OUT;

@Component
public class NegativityListener {

    private final Logger logger = LoggerFactory.getLogger(NegativityListener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private NegativityDetectionService service;

    @KafkaListener(id = "default", topics = TOPIC_IN)
    public void consume(String message) {
        logger.info("### Incoming message: {}", message);
        String processedMessage = service.process(message);
        logger.info("### Outgoing message: {}", processedMessage);
        kafkaTemplate.send(TOPIC_OUT, processedMessage);
    }

}
