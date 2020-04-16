package com.yisu.jedis.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public  class JedisUtilsTest {

    @Autowired
    private JedisUtils jedisUtils;



    @Test
    public void setTest(){

        String set = jedisUtils.set("tenant:test", String.valueOf(System.currentTimeMillis()), 0);
        log.info(set);
    }


}