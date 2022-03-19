package com.adamhosman.springcloudstreamdemo.processor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ProfanityDetectionService {

    Logger logger = LoggerFactory.getLogger(ProfanityDetectionService.class);

    private static final String PROFANITIES_PATTERN = "(?i)(balls|bollocks|bastard|bloody|bugger|cow|crap|damn|git|minger|sod-off)";

    public Optional<String> process(String message) {
        String processed = message.replaceAll(PROFANITIES_PATTERN, "unicorns");
        if (!Objects.equals(message, processed)) {
            logger.info("### Profanity detected");
        }
        return Optional.of(processed);
    }

}
