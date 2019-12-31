package com.yisu.zuul.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/31
 */
@EnableZuulProxy
@SpringBootApplication
public class FwZuulSimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwZuulSimpleApplication.class, args);
    }
}