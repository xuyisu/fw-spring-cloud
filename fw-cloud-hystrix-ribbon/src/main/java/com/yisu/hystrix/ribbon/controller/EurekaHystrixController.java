package com.yisu.hystrix.ribbon.controller;

import com.yisu.hystrix.ribbon.entity.User;
import com.yisu.hystrix.ribbon.service.EurekaHystrixRibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
