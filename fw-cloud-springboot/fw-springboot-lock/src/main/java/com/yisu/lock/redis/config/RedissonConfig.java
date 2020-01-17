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

//    @Bean
//    public RedissonClient redissonClient()
//    {
//        Config config = new Config();
//        config.useSentinelServers()
//                .addSentinelAddress("redis://127.0.0.1:26379")
//                .addSentinelAddress("redis://127.0.0.2:26379")
//                .addSentinelAddress("redis://127.0.0.3:26379")
//                .setPassword(redissonPassword);
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }

//    @Bean
//    public RedissonClient redissonClient()
//    {
//        Config config = new Config();
//        config.useClusterServers()
//                // 集群状态扫描间隔时间，单位是毫秒
//                .setScanInterval(2000)
//                //cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
//                .addNodeAddress("redis://127.0.0.1:6379" )
//                .addNodeAddress("redis://127.0.0.1:6380")
//                .addNodeAddress("redis://127.0.0.1:6381")
//                .addNodeAddress("redis://127.0.0.1:6382")
//                .addNodeAddress("redis://127.0.0.1:6383")
//                .addNodeAddress("redis://127.0.0.1:6384")
//                .setPassword(redissonPassword);
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }
}
