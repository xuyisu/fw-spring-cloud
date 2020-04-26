package com.yisu.mq.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "test-group", topic = "test-topic")
public class TestRocketMQListener implements RocketMQListener<String> {



    @Override
    public void onMessage(String  message) {
        log.info("FwReceiver=>{}", message);
    }

}