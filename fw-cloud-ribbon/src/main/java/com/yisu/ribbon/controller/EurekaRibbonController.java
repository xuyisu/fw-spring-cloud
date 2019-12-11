package com.yisu.ribbon.controller;

import com.yisu.ribbon.service.EurekaRibbonService;
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

    @RequestMapping("/info")
    public List<String> ribbonInfo() {
        List<String> eurekaServices = eurekaRibbonService.getEurekaServices();
        return eurekaServices;
    }
}
