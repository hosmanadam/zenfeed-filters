package com.adamhosman.springcloudstreamdemo.processor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpamDetectionService {

    Logger logger = LoggerFactory.getLogger(SpamDetectionService.class);

    private static final String SPAM_PATTERN = "(?i).*(sale|offer|bargain|save|only now|limited time|opportunity|singles|near you).*";

    public Optional<String> process(String message) {
        if (message.matches(SPAM_PATTERN)) {
            logger.info("### Spam detected, message blocked");
            return Optional.empty();
        }
        String tagged = message + " #NoSpam";
        return Optional.of(tagged);
    }

}
