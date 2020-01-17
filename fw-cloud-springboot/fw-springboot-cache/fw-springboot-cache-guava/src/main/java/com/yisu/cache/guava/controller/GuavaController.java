package com.yisu.cache.guava.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.yisu.cache.guava.entity.User;
import com.yisu.cache.guava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
