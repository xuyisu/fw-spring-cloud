package com.yisu.register.zookeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String HelloWorld() {
        return "Hello World!";
    }
}
