package com.yisu.feign.without.controller;

import com.yisu.feign.without.entity.User;
import com.yisu.feign.without.service.HelloClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuyisu
 * @description 测试不在SpringCloud项目里使用Feign
 * @date 2019/12/29
 */
@RestController
public class TestController {

    /**
     * 测试请求
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        HelloClient hello = Feign.builder().target(HelloClient.class, "http://localhost:8764/");
        return hello.hello();
    }

    /**
     * 测试请求根据id获取用户
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id){
        HelloClient hello = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, "http://localhost:8764/");
        return hello.getUserById(id);
    }

    /**
     * 测试请求根据id获取用户
     * @return
     */
    @PostMapping("/getUsers")
    public List<User> getUsers(){
        HelloClient hello = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, "http://localhost:8764/");
        return hello.getUsers();
    }
}
