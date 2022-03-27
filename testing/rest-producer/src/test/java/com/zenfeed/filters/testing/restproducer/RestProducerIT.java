//package com.zenfeed.filters.testing.restproducer;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.stream.test.binder.MessageCollector;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.concurrent.BlockingQueue;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class RestProducerIT {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    @Qualifier("producer-out-0")
//    private MessageChannel output;
//
//    @Autowired
//    private MessageCollector messageCollector;
//    private BlockingQueue<Message<?>> outputCollector;
//
//    @BeforeEach
//    private void setUp() {
//        outputCollector = messageCollector.forChannel(output);
//    }
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void producesMessage() throws Exception {
//        String requestBody = "Could you send this message please?";
//
//        mockMvc.perform(post("/produce").content(requestBody));
//
//        assertThat(outputCollector, receivesPayloadThat(is(requestBody)));
//    }
//
//}
