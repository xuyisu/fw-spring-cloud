package com.yisu.mq.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xuyisu
 * @description 接收方
 * @date 2019/12/18
 */
@Component
@RabbitListener(queues = "hello")
@Slf4j
public class FwReceiver {

    @RabbitHandler
    public void process(String msg){
        log.info("FwReceiver:{}",msg);
    }
}
