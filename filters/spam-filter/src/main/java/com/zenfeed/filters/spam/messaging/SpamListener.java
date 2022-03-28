package com.zenfeed.filters.spam.messaging;

import com.zenfeed.filters.spam.service.SpamDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.zenfeed.filters.spam.messaging.MessagingConfiguration.QUEUE_IN;
import static com.zenfeed.filters.spam.messaging.MessagingConfiguration.QUEUE_OUT;

@Component
public class SpamListener {

    private final Logger logger = LoggerFactory.getLogger(SpamListener.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SpamDetectionService service;

    @RabbitListener(queues = QUEUE_IN)
    public void consume(String message) {
        logger.info("### Incoming message: {}", message);
        Optional<String> processedMessage = service.process(message);
        if (processedMessage.isPresent()) {
            logger.info("### Outgoing message: {}", processedMessage.get());
            rabbitTemplate.convertAndSend(QUEUE_OUT, processedMessage.get());
        }
    }

}
