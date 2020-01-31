package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * @Author xuyisu
 * @Date 2020/1/31
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class FwZuulExtendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwZuulExtendApplication.class, args);
    }


}