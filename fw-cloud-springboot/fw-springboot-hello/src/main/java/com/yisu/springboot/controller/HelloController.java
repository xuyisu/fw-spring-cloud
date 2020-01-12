package com.yisu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description hello
 * @date 2019/12/13
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){
        return "hello:"+name;
    }
}
