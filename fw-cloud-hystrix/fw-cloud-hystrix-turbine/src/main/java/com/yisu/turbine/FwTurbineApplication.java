package com.yisu.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class FwTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwTurbineApplication.class, args);
    }


}