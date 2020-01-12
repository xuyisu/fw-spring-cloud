package com.yisu.mq.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author xuyisu
 * @description 接收方
 * @date 2019/12/18
 */
@Component
@Slf4j
public class FwReceiver {

    @KafkaListener(topics = "fwcloud")
    public void onMessage(String message){
        log.info(message);
    }
}
