package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author xuyisu
 * @date 2019/12/6
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FwClientZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwClientZookeeperApplication.class, args);
    }


}