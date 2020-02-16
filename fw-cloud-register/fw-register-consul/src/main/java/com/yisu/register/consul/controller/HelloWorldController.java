package com.yisu.register.consul.controller;

import com.yisu.feign.api.ConsulApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class HelloWorldController implements ConsulApi {

    /**
     * 测试接口，实际生产可删除
     * @return
     */
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
}
