package com.yisu.register.consul.controller;

import com.yisu.feign.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class HelloWorldController{
    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World!";
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public User getUser() {
        return new User(1L,"consul","test","test@qq.com","演示Consul 替换Eureka");
    }
}
