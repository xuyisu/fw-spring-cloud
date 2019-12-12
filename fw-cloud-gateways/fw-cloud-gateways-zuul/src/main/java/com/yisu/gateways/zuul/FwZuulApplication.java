package com.yisu.gateways.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class FwZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwZuulApplication.class, args);
    }


}