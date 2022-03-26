package com.adamhosman.springcloudstreamdemo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/produce")
    public void produce(@RequestBody String message) {
        logger.info("### Sending message: {}", message);
        streamBridge.send("producer-out-0", message);
    }

}
