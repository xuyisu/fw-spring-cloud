package com.yisu.config.client.jce.controller;

import com.yisu.base.dao.service.SysUserService;
import com.yisu.common.result.FwResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SysUserController
 *
 * @author xuyisu
 * @date 2020-03-22
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;



    /**
     * 获取全部用户
     *
     * @return
     */
    @PostMapping("/getUsers")
    public FwResult getUsers() {
        return FwResult.ok(sysUserService.list());
    }
}
