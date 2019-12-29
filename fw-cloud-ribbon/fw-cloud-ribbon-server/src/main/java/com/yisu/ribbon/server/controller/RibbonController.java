package com.yisu.ribbon.server.controller;

import com.yisu.ribbon.server.entity.User;
import com.yisu.ribbon.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuyisu
 * @description ribbon demo接口演示
 * @date 2019/12/11
 */
@RestController
@RequestMapping("user")
public class RibbonController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id, HttpServletRequest req){
        String url = req.getRequestURL().toString();
        User user = userService.getUserById(id);
        user.setRemark(user.getRemark()+":提供服务的是:"+url);
        return user;
    }

}
