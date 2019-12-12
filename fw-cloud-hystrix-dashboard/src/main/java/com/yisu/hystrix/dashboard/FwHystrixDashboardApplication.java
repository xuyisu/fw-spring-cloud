package com.yisu.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 基于feign
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class FwHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwHystrixDashboardApplication.class, args);
    }


}