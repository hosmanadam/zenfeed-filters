package com.zenfeed.filters.profanity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProfanityDetectionService {

    private static final String FILTERED_TAG = " #NoProfanity";
    private static final String PROFANITIES_PATTERN = "(?i)(balls|bollocks|bastard|bloody|bugger|cow|crap|damn|git|minger|sod-off)";
    private static final String INOFFENSIVE_REPLACEMENT_WORD = "unicorns";
    private final Logger logger = LoggerFactory.getLogger(ProfanityDetectionService.class);

    public String process(String message) {
        String processed = message.replaceAll(PROFANITIES_PATTERN, INOFFENSIVE_REPLACEMENT_WORD);
        if (!Objects.equals(message, processed)) {
            logger.info("### Profanity detected and corrected");
        }
        return processed + FILTERED_TAG;
    }

}
