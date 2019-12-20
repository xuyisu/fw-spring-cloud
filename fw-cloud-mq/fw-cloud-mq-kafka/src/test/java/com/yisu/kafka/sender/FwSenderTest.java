package com.yisu.kafka.sender;

import com.yisu.mq.kafka.sender.FwSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FwSenderTest {

    @Autowired
    private FwSender fwSender;

    @Test
    void send() {
        for (int i = 0; i <10 ; i++) {
            fwSender.send();
        }
    }
}