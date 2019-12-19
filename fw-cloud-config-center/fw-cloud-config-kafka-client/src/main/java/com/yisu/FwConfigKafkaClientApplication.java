package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FwConfigKafkaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwConfigKafkaClientApplication.class, args);
    }
}
