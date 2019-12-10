package com.yisu.ribbon.controller;

import com.yisu.ribbon.service.EurekaRibbonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuyisu
 * @description controller
 * @date 2019/12/10
 */
@RestController
public class EurekaRibbonController {


    @Resource
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("/info")
    public String ribbonInfo() {
        String message = eurekaRibbonService.getInfo();
        return message;
    }
}
