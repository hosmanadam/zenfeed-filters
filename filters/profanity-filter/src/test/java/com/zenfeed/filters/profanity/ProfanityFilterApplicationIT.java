package com.zenfeed.filters.profanity;

import com.zenfeed.filters.profanity.messaging.ProfanityListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.TOPIC_OUT;

@SpringBootTest
class ProfanityFilterApplicationIT {

    @Autowired
    private ProfanityListener profanityListener;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void correctsProfanities() {
        String inputMessage = "This is totally bollocks";

        profanityListener.consume(inputMessage);

        Mockito.verify(kafkaTemplate).send(TOPIC_OUT, "This is totally unicorns #NoProfanity");
    }

}
