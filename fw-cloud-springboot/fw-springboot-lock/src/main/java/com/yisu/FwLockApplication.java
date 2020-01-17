package com.yisu;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@SpringBootApplication
public class FwLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwLockApplication.class, args);
    }


}