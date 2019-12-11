package com.yisu.ribbon.controller;

import com.yisu.ribbon.entity.User;
import com.yisu.ribbon.service.EurekaRibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuyisu
 * @description controller
 * @date 2019/12/10
 */
@RestController
public class EurekaRibbonController {


    @Resource
    private EurekaRibbonService eurekaRibbonService;

    /**
     * 获取注册服务信息
     * @return
     */
    @GetMapping("/info")
    public List<String> ribbonInfo() {
        List<String> eurekaServices = eurekaRibbonService.getEurekaServices();
        return eurekaServices;
    }

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
