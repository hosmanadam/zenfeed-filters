package com.zenfeed.filters.spam;

import com.zenfeed.filters.spam.messaging.SpamListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static com.zenfeed.filters.spam.messaging.MessagingConfiguration.TOPIC_OUT;
import static com.zenfeed.filters.spam.service.SpamDetectionService.PROCESSED_TAG;

@SpringBootTest
class SpamFilterApplicationIT {

    @Autowired
    private SpamListener spamListener;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void tagsNonSpam() {
        String inputMessage = "I'm not selling anything";

        spamListener.consume(inputMessage);

        Mockito.verify(kafkaTemplate).send(TOPIC_OUT, inputMessage + PROCESSED_TAG);
    }

    @Test
    void blocksSpam() {
        String inputMessage = "$$$ Save 10,000 CHF, for a limited time only $$$";

        spamListener.consume(inputMessage);

        Mockito.verifyNoInteractions(kafkaTemplate);
    }

}
