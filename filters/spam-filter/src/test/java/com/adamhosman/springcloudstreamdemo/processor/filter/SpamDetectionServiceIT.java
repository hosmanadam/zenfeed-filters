package com.adamhosman.springcloudstreamdemo.processor.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.BlockingQueue;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

@SpringBootTest
class SpamDetectionServiceIT {

    @Autowired
    @Qualifier("spamFilter-in-0")
    private MessageChannel input;

    @Autowired
    @Qualifier("spamFilter-out-0")
    private MessageChannel output;

    @Autowired
    private MessageCollector messageCollector;
    private BlockingQueue<Message<?>> outputCollector;

    @BeforeEach
    private void setUp() {
        outputCollector = messageCollector.forChannel(output);
    }

    @Test
    void tagsNonSpam() {
        String inputMessage = "I'm not selling anything";

        input.send(new GenericMessage<>(inputMessage));

        assertThat(outputCollector, receivesPayloadThat(is("I'm not selling anything #NoSpam")));
    }

    @Test
    void blocksSpam() {
        String inputMessage = "$$$ Save 10,000 CHF, for a limited time only $$$";

        input.send(new GenericMessage<>(inputMessage));

        assertMessageNotReceived(outputCollector);
    }

    private static void assertMessageNotReceived(BlockingQueue<Message<?>> outputCollector) {
        Message<?> message = poll(outputCollector);
        assertNull(message);
    }

    private static Message<?> poll(BlockingQueue<Message<?>> outputCollector) {
        Message<?> message;
        try {
            int estimatedMaxSecondsForTestBinderToDeliverMessage = 2;
            message = outputCollector.poll(estimatedMaxSecondsForTestBinderToDeliverMessage, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

}
