package com.yisu.ribbon.server.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.yisu.ribbon.server.entity.User;
import com.yisu.ribbon.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xuyisu
 * @description ribbon demo接口演示
 * @date 2019/12/11
 */
@RestController
@RequestMapping("user")
@Slf4j
public class RibbonController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id, HttpServletRequest req) throws InterruptedException {
//        int millis = new Random().nextInt(3000);
//        System.out.println("client线程休眠时间："+millis);
//        Thread.sleep(millis);
//        if(millis>1000){
//            throw new RuntimeException("error");
//        }
        log.info(ServletUtil.getClientIP(req));
        String url = req.getRequestURL().toString();
        User user = userService.getUserById(id);
        user.setRemark(user.getRemark()+":提供服务的是:"+url);
        return user;
    }

    /**
     * 配合gateway
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/header")
    public String header(@RequestHeader(value = "Host", required = false)  String host,
                         @RequestHeader(value = "Blue", required = false)  String blue,
                         @RequestHeader(value = "X-Request-Red", required = false)  String requestRed) {

        StringBuilder sp=new StringBuilder();
//        if(StrUtil.isNotBlank(host)){
//            sp.append("Host:").append(host).append(System.lineSeparator());
//        }
        if(StrUtil.isNotBlank(host)){
            sp.append("Blue:").append(blue).append(System.lineSeparator());
        }
        if(StrUtil.isNotBlank(host)){
            sp.append("X-Request-Red:").append(requestRed).append(System.lineSeparator());
        }
        return sp.toString();
    }

    @GetMapping("/list")
    public List<User> getUserById(String  ids, HttpServletRequest req){
        log.info("ids,{}",ids);
        List<User> list=new ArrayList<>();
        String[] splitIds = ids.split(",");
        for (String id : splitIds) {
            String url = req.getRequestURL().toString();
            User user = userService.getUserById(Long.valueOf(id));
            user.setRemark(user.getRemark()+":提供服务的是:"+url);
            list.add(user);
        }
        return list;
    }




}
