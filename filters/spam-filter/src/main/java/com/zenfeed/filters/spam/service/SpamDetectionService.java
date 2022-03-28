package com.zenfeed.filters.spam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpamDetectionService {

    public static final String PROCESSED_TAG = " #NoSpam";
    private static final String SPAM_PATTERN = "(?i).*(sale|offer|bargain|save|only now|limited time|opportunity|singles|near you).*";
    private final Logger logger = LoggerFactory.getLogger(SpamDetectionService.class);

    public Optional<String> process(String message) {
        if (message.matches(SPAM_PATTERN)) {
            logger.info("### Spam detected, message blocked");
            return Optional.empty();
        }
        return Optional.of(message + PROCESSED_TAG);
    }

}
