package com.yisu.client.nacos.controller;

import com.yisu.client.nacos.feign.NacosApi;
import com.yisu.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/26
 */
@RestController
public class TestController {

    @Autowired
    private NacosApi nacosApi;

    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return nacosApi.helloWorld();
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public User user() {
        return nacosApi.getUser();
    }
}
