package com.adamhosman.springcloudstreamdemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProducerController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/produce")
    public void produce(@RequestBody String message) {
        streamBridge.send("producer-out-0", message);
    }

}
