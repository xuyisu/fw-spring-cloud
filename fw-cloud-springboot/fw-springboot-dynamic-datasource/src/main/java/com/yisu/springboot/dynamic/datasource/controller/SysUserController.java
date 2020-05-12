package com.yisu.springboot.dynamic.datasource.controller;

import com.yisu.common.result.FwResult;
import com.yisu.springboot.dynamic.datasource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("selectByMaster")
    public FwResult selectByMaster(){
        return  FwResult.ok(sysUserService.selectByMaster());
    }

    @PostMapping("selectBySlaveOne")
    public FwResult selectBySlaveOne(){
        return  FwResult.ok(sysUserService.selectBySlaveOne());
    }


    @PostMapping("selectBySlaveTwo")
    public FwResult selectBySlaveTwo(){
        return  FwResult.ok(sysUserService.selectBySlaveTwo());
    }
}
