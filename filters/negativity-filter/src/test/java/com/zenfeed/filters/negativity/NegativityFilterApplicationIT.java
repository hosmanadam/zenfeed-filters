package com.zenfeed.filters.negativity;

import com.zenfeed.filters.negativity.messaging.NegativityListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.zenfeed.filters.negativity.messaging.MessagingConfiguration.QUEUE_OUT;

@SpringBootTest
class NegativityFilterApplicationIT {

    @Autowired
    private NegativityListener negativityListener;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void correctsNegativity() {
        String inputMessage = "I could never do that";

        negativityListener.consume(inputMessage);

        Mockito.verify(rabbitTemplate).convertAndSend(QUEUE_OUT, "I could always do that #NoNegativity");
    }

}
