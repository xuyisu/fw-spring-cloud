package com.yisu.register.zookeeper.controller;

import com.yisu.feign.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public User getUser() {
        return new User(1L,"zookeeper","test","test@qq.com","演示Zookeeper 替换Eureka");
    }
}
