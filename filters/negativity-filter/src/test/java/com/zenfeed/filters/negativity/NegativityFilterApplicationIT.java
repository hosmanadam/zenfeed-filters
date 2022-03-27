//package com.zenfeed.filters.negativity;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.stream.test.binder.MessageCollector;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.GenericMessage;
//
//import java.util.concurrent.BlockingQueue;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;
//
//@SpringBootTest
//class NegativityFilterApplicationIT {
//
//    @Autowired
//    @Qualifier("negativityFilter-in-0")
//    private MessageChannel input;
//
//    @Autowired
//    @Qualifier("negativityFilter-out-0")
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
//    void correctsNegativity() {
//        String inputMessage = "I could never do that";
//
//        input.send(new GenericMessage<>(inputMessage));
//
//        assertThat(outputCollector, receivesPayloadThat(is("I could always do that #NoNegativity")));
//    }
//
//}
