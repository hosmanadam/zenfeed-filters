package com.zenfeed.filters.negativity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class NegativityDetectionService {

    private final Logger logger = LoggerFactory.getLogger(NegativityDetectionService.class);

    private static final Map<String, String> NEGATIVE_TO_POSITIVE = Map.of(
            "can't", "can",
            "cannot", "can",
            "depressed", "motivated",
            "lousy", "great",
            "negative", "positive",
            "never", "always",
            "terrible", "fantastic"
    );

    public Optional<String> process(String message) {
        String processed = message;
        for (Map.Entry<String, String> entry : NEGATIVE_TO_POSITIVE.entrySet()) {
            processed = processed.replaceAll(entry.getKey(), entry.getValue());
        }
        if (!Objects.equals(message, processed)) {
            logger.info("### Negativity detected and corrected");
        }
        String tagged = processed + " #NoNegativity";
        return Optional.of(tagged);
    }

}
