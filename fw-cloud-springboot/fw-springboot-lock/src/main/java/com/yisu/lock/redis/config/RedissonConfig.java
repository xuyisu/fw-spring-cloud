package com.yisu.lock.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${redisson.address}")
    private String redissonAddress;

    @Value("${redisson.password}")
    private String redissonPassword;

    @Bean
    public RedissonClient redissonClient()
    {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redissonAddress).setPassword(redissonPassword);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
