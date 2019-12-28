package com.yisu.feign.controller;

import com.yisu.feign.service.EurekaFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuyisu
 * @description controller
 * @date 2019/12/11
 */
@RestController
@Slf4j
public class EurekaFeignController {

    @Resource
    private EurekaFeignService eurekaFeignService;

    @GetMapping("/feignInfo")
    public String feignInfo() {
        String message = eurekaFeignService.hello();
        log.info(message);
        return message;
    }


}
