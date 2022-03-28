package com.zenfeed.filters.profanity.messaging;

import com.zenfeed.filters.profanity.service.ProfanityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.QUEUE_IN;
import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.QUEUE_OUT;

@Component
public class ProfanityListener {

    private final Logger logger = LoggerFactory.getLogger(ProfanityListener.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProfanityDetectionService service;

    @RabbitListener(queues = QUEUE_IN)
    public void consume(String message) {
        logger.info("### Incoming message: {}", message);
        String processedMessage = service.process(message);
        logger.info("### Outgoing message: {}", processedMessage);
        rabbitTemplate.convertAndSend(QUEUE_OUT, processedMessage);
    }

}
