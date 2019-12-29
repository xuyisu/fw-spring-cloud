package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 基于feign
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableFeignClients
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class FwHystrixFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwHystrixFeignApplication.class, args);
    }


}