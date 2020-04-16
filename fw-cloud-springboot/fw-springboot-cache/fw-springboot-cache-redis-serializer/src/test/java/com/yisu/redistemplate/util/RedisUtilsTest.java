package com.yisu.redistemplate.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class RedisUtilsTest {


    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<?, ?> redisTemplate;


    /**
     * 测试使用工具类
     */
    @Test
    public void redisUtilTest() {
        redisUtils.set("xuyisu", "666");
        log.info(redisUtils.get("xuyisu"));
    }

    /**
     * 测试StringRedisTemplate
     */
    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("zhangsan", "999");
        log.info(stringRedisTemplate.opsForValue().get("zhangsan"));
    }

    /**
     * 测试RedisTemplate
     */
    @Test
    public void testRedisTemplate() {
        ValueOperations<String, String> operations = (ValueOperations<String, String>) redisTemplate
                .opsForValue();
        operations.set("lisi", "999");
        String lisi = operations.get("lisi");
        log.info(lisi);
    }
}