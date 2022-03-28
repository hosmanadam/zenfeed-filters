package com.zenfeed.filters.testing.restproducer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static com.zenfeed.filters.testing.restproducer.configuration.MessagingConfiguration.TOPIC_OUT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class RestProducerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void producesMessage() throws Exception {
        String requestBody = "Could you send this message please?";

        mockMvc.perform(post("/produce").content(requestBody));

        Mockito.verify(kafkaTemplate).send(TOPIC_OUT, requestBody);
    }

}
