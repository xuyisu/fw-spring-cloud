package com.yisu.stream.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/20
 */
@EnableBinding(Sink.class)
@Slf4j
public class SinkServer {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        log.info("receive,{}",payload);

    }
}
