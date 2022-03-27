package com.zenfeed.filters.profanity;

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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

@SpringBootTest
class ProfanityFilterApplicationIT {

    @Autowired
    @Qualifier("profanityFilter-in-0")
    private MessageChannel input;

    @Autowired
    @Qualifier("profanityFilter-out-0")
    private MessageChannel output;

    @Autowired
    private MessageCollector messageCollector;
    private BlockingQueue<Message<?>> outputCollector;

    @BeforeEach
    private void setUp() {
        outputCollector = messageCollector.forChannel(output);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void correctsProfanities() {
        String inputMessage = "This is totally bollocks";

        input.send(new GenericMessage<>(inputMessage));

        assertThat(outputCollector, receivesPayloadThat(is("This is totally unicorns #NoProfanity")));
    }

}
