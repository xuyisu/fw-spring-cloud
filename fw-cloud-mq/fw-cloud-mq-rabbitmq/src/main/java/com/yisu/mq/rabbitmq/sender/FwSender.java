package com.yisu.mq.rabbitmq.sender;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xuyisu
 * @description 发送方
 * @date 2019/12/18
 */
@Component
@Slf4j
public class FwSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
      String message="Hello World:"+ DateUtil.now();
      log.info("FwSender:"+message);
      //第一个参数是topic，第二个参数是内容
      amqpTemplate.convertAndSend("hello",message);
    }
}
