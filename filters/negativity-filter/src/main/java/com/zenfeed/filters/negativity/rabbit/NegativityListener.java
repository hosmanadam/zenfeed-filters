package com.zenfeed.filters.negativity.rabbit;

import com.zenfeed.filters.negativity.service.NegativityDetectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.negativity.rabbit.RabbitConfiguration.QUEUE_IN;
import static com.zenfeed.filters.negativity.rabbit.RabbitConfiguration.QUEUE_OUT;

@Component
public class NegativityListener {

    private final Logger logger = LoggerFactory.getLogger(NegativityListener.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private NegativityDetectionService service;

    @RabbitListener(queues = QUEUE_IN)
    public void negativityListener(String message) {
        logger.info("### Incoming message: {}", message);
        String processedMessage = service.process(message);
        logger.info("### Outgoing message: {}", processedMessage);
        rabbitTemplate.convertAndSend(QUEUE_OUT, processedMessage);
    }

}
