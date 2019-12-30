package com.yisu.hystrix.ribbon.controller;

import com.yisu.hystrix.ribbon.entity.User;
import com.yisu.hystrix.ribbon.service.EurekaHystrixRibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description controller
 * @date 2019/12/10
 */
@RestController
public class EurekaHystrixController {


    @Resource
    private EurekaHystrixRibbonService eurekaRibbonService;


    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id:\\d+}")
    public User findUserById(@PathVariable long id){
        return eurekaRibbonService.findUserById(id);
    }

    /**
     * 根据id获取用户信息
     * @return
     */
    @GetMapping("/user/list")
    public List<User> findUsers() throws ExecutionException, InterruptedException {
        Future<User> userSingle1 = eurekaRibbonService.getUserSingle(1L);
        Future<User> userSingle2 = eurekaRibbonService.getUserSingle(2L);
        Future<User> userSingle3 = eurekaRibbonService.getUserSingle(3L);
        List<User> list=new ArrayList<>();
        list.add(userSingle1.get());
        list.add(userSingle2.get());
        list.add(userSingle3.get());
        return list;
    }
}
