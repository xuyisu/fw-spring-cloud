package com.yisu.starter.sample.autoconfigure.service;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SampleService {

    private String user;

    public String sayHello(){
        return "当前配置用户:"+user;
    }
}
