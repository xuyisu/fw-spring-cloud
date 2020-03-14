package com.yisu.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description demo 控制层
 * @date 2020/3/14
 */
@RestController
public class DemoController {

    /**
     * @return hello World
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello,World";
    }

}
