package com.yisu.client.consul.controller;

import com.yisu.client.consul.feign.ConsulApi;
import com.yisu.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class TestController {

    @Autowired
    private ConsulApi helloApi;

    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return helloApi.helloWorld();
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public User user() {
        return helloApi.getUser();
    }
}
