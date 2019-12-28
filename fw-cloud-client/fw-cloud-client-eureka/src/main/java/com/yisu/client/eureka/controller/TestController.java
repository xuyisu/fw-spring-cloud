package com.yisu.client.eureka.controller;

import com.yisu.client.eureka.entity.User;
import com.yisu.client.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
 * @description
 * @author xuyisu
 * @date 2019/12/9
 */

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String  serverPort;
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
    public String hello() throws InterruptedException {

//        int millis = new Random().nextInt(3000);
//        System.out.println("client线程休眠时间："+millis);
//        Thread.sleep(millis);
        return "hello:"+serverPort;
    }
}
