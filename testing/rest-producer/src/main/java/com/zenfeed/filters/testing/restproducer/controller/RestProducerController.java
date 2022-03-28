package com.zenfeed.filters.testing.restproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.zenfeed.filters.testing.restproducer.configuration.MessagingConfiguration.TOPIC_OUT;

@RestController
@RequestMapping
public class RestProducerController {

    private final Logger logger = LoggerFactory.getLogger(RestProducerController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/produce")
    public void produce(@RequestBody String message) {
        logger.info("### New message: {}", message);
        kafkaTemplate.send(TOPIC_OUT, message);
    }

}
