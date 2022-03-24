package com.adamhosman.springcloudstreamdemo.processor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ProfanityDetectionService {

    private final Logger logger = LoggerFactory.getLogger(ProfanityDetectionService.class);

    private static final String PROFANITIES_PATTERN = "(?i)(balls|bollocks|bastard|bloody|bugger|cow|crap|damn|git|minger|sod-off)";
    private static final String INOFFENSIVE_REPLACEMENT_WORD = "unicorns";

    public Optional<String> process(String message) {
        String processed = message.replaceAll(PROFANITIES_PATTERN, INOFFENSIVE_REPLACEMENT_WORD);
        if (!Objects.equals(message, processed)) {
            logger.info("### Profanity detected and corrected");
        }
        String tagged = processed + " #NoProfanity";
        return Optional.of(tagged);
    }

}
