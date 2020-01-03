package com.yisu.gateways.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description forward转发
 * @date 2020/1/3
 */
@RestController
public class LocalController {

    @GetMapping("/local/user/{id:\\d+}")
    public String getId(@PathVariable Long id){
        return id.toString()+",我是forward转发来的";
    }
}
