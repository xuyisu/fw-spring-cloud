package com.yisu.client.zookeeper.controller;

import com.yisu.client.zookeeper.api.HelloWorldApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description 测试zk注册中心
 * @date 2019/12/9
 */
@RestController
public class TestController {
    @Autowired
    private HelloWorldApi helloWorldApi;

    @GetMapping("/hello")
    public String hello() {

        return helloWorldApi.HelloWorld();

    }
}
