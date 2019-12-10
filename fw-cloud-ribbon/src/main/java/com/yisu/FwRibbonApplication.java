package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class FwRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwRibbonApplication.class, args);
    }


}