package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 * @Author xuyisu
 * @Date 2019/12/6
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FwTransactionSeataTccSendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwTransactionSeataTccSendApplication.class, args);
    }


}