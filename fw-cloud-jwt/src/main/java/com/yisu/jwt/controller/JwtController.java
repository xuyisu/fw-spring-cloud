package com.yisu.jwt.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yisu.base.dao.model.SysUser;
import com.yisu.base.dao.service.SysUserService;
import com.yisu.common.result.FwResult;
import com.yisu.jwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JwtController
 *
 * @author xuyisu
 * @date 2020-03-22
 */
@RestController
public class JwtController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 登陆
     *
     * @param userName 用户名
     * @param passWord 密码
     * @return
     */
    @PostMapping("/login")
    public FwResult login(String userName, String passWord) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        SysUser userOne = sysUserService.getOne(Wrappers.query(sysUser));
        if (userOne == null) {
            return FwResult.failedMsg("用户不存在");
        }
        if (!passWord.equals(userOne.getPassword())) {
            return FwResult.failedMsg("密码错误");
        } else {
            String token = jwtTokenUtil.getToken(userOne);
            return FwResult.ok(token);
        }
    }


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
