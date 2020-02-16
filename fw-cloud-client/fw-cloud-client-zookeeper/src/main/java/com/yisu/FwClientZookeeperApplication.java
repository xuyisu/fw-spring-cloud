package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author xuyisu
 * @date 2019/12/6
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FwClientZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwClientZookeeperApplication.class, args);
    }


}