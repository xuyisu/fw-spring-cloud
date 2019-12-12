package com.yisu.config.natives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@EnableConfigServer
@SpringBootApplication
public class FwConfigNativeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwConfigNativeServerApplication.class, args);
    }
}
