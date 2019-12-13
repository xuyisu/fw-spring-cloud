package com.yisu.client.eureka.controller;

import com.yisu.client.eureka.entity.User;
import com.yisu.client.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    /**
     * 获取全部用户
     * @return
     */
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
