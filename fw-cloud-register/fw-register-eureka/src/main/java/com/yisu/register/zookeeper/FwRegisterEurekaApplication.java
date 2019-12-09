package com.yisu.register.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableEurekaServer
@SpringBootApplication
public class FwRegisterEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwRegisterEurekaApplication.class, args);
    }


}