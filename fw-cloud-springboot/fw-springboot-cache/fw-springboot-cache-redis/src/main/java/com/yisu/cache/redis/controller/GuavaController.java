package com.yisu.cache.redis.controller;

import com.yisu.cache.redis.entity.User;
import com.yisu.cache.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description guava demo接口演示
 * @date 2020/01/18
 */
@RestController
@RequestMapping("user")
@Slf4j
public class GuavaController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        user.setRemark(user.getRemark());
        return user;
    }



}
