package com.yisu.mq.kafka.sender;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean send(){
        String message="Hello World:"+ DateUtil.now();
        log.info("FwSender:"+message);
        //第一个参数是topic，第二个参数是内容
        kafkaTemplate.send("fwcloud",message);
        return true;
    }
}
