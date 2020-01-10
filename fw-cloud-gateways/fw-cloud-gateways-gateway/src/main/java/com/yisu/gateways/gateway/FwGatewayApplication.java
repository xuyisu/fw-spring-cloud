package com.yisu.gateways.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FwGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwGatewayApplication.class, args);
    }

}