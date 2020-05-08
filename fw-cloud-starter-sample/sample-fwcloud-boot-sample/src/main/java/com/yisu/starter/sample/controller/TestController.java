package com.yisu.starter.sample.controller;

import com.yisu.starter.sample.autoconfigure.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SampleService sampleService;


    @GetMapping("/test")
    public String  test(){
        return sampleService.sayHello();
    }

}
