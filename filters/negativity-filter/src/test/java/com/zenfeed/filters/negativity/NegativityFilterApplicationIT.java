package com.zenfeed.filters.negativity;

import com.zenfeed.filters.negativity.messaging.NegativityListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static com.zenfeed.filters.negativity.messaging.MessagingConfiguration.TOPIC_OUT;

@SpringBootTest
class NegativityFilterApplicationIT {

    @Autowired
    private NegativityListener negativityListener;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void correctsNegativity() {
        String inputMessage = "I could never do that";

        negativityListener.consume(inputMessage);

        Mockito.verify(kafkaTemplate).send(TOPIC_OUT, "I could always do that #NoNegativity");
    }

}
