package com.yisu.admin.eureka;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
public class BootAdminEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootAdminEurekaApplication.class, args);
    }


}