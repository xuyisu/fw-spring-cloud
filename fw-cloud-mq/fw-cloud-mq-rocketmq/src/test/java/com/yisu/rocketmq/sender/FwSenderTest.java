package com.yisu.rocketmq.sender;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FwSenderTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void send() {
        for (int i = 0; i <10 ; i++) {
            rocketMQTemplate.convertAndSend("test-topic","hello world"+i);
        }
    }
}