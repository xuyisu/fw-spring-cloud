package com.yisu.mq.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xuyisu
 * @description RabbitMq配置
 * @date 2019/12/18
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 注册一个名为hello的队列
     * @return
     */
    @Bean
    public Queue helloQueue(){
        return  new Queue("hello");
    }
}
