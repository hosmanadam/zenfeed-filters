package com.zenfeed.filters.testing.loggingconsumer.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zenfeed.filters.testing.loggingconsumer.rabbit.RabbitConfiguration.QUEUE_IN;

@Component
public class LoggingListener {

    private final Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @RabbitListener(queues = QUEUE_IN)
    public void loggingListener(String message) {
        logger.info("### Final message: {}", message);
    }

}
