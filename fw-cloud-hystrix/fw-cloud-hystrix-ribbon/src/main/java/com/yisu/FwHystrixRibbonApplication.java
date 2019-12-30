package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class FwHystrixRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwHystrixRibbonApplication.class, args);
    }


}