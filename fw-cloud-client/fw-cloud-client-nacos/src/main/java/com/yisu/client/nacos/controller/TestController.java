package com.yisu.client.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/26
 */
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/test")
    public String echo() {
        return restTemplate.getForObject("http://fw-cloud-nacos-register/get", String.class);
    }

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://fw-cloud-nacos-register/echo/" + str, String.class);
    }
}
