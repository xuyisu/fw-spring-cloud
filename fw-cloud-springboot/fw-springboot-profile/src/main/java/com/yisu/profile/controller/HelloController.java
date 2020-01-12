package com.yisu.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${version}")
    String version;

    /**
     * 获取版本信息
     * @return
     */
    @GetMapping("/version")
    public String getVersion(){
        return version;
    }

}
