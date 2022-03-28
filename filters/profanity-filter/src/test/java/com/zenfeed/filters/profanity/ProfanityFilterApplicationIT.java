//package com.zenfeed.filters.profanity;
//
//import com.zenfeed.filters.profanity.messaging.ProfanityListener;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static com.zenfeed.filters.profanity.messaging.MessagingConfiguration.TOPIC_OUT;
//
//@SpringBootTest
//class ProfanityFilterApplicationIT {
//
//    @Autowired
//    private ProfanityListener profanityListener;
//
//    @MockBean
//    private RabbitTemplate rabbitTemplate;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void correctsProfanities() {
//        String inputMessage = "This is totally bollocks";
//
//        profanityListener.consume(inputMessage);
//
//        Mockito.verify(rabbitTemplate).convertAndSend(TOPIC_OUT, "This is totally unicorns #NoProfanity");
//    }
//
//}
