package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FwClientNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwClientNacosApplication.class, args);
    }
}
