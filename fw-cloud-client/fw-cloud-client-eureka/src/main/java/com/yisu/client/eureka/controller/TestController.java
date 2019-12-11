package com.yisu.client.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class TestController {


    @GetMapping("/hello")
    public String test() {
        return "hello";
    }
}
