package com.yisu.swagger.controller;

import com.yisu.swagger.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description hello
 * @date 2019/12/13
 */
@RestController
public class HelloController {

    @ApiOperation(value = "你好世界")
    @GetMapping("/hello")
    public String hello(String name){
        return "hello:"+name;
    }


    @ApiOperation(value = "用户信息")
    @GetMapping("/user")
    public SysUser user(@RequestBody SysUser sysUser){
        return sysUser;
    }
}
