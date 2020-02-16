package com.yisu.client.consul.controller;

import com.yisu.feign.api.ConsulApi;
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

    @GetMapping("/test")
    public String test() {
        return helloApi.helloWorld();
    }
}
