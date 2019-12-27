package com.yisu.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description 测试log
 * @date 2019/12/27
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(String test){
        log.info("hello,{}",test);
        return "hello:"+test;
    }
}
