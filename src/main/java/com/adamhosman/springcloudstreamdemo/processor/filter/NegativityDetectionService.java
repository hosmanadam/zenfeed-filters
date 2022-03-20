package com.adamhosman.springcloudstreamdemo.processor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class NegativityDetectionService {

    private final Logger logger = LoggerFactory.getLogger(NegativityDetectionService.class);

    private static final Map<String, String> NEGATIVE_POSITIVE = Map.of(
            "negative", "positive",
            "can't", "can",
            "cannot", "can",
            "terrible", "fantastic",
            "lousy", "great",
            "depressed", "motivated"
    );

    public Optional<String> process(String message) {
        String processed = message;
        for (Map.Entry<String, String> entry : NEGATIVE_POSITIVE.entrySet()) {
            processed = processed.replaceAll(entry.getKey(), entry.getValue());
        }
        if (!Objects.equals(message, processed)) {
            logger.info("### Negativity detected and corrected");
        }
        String tagged = processed + " #NoNegativity";
        return Optional.of(tagged);
    }

}
