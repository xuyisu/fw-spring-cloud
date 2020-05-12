package com.yisu.springboot.dynamic.datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yisu.springboot.dynamic.datasource.model.SysUser;

import java.util.List;

/**
 * @description 系统用户表-业务接口
 * @author xuyisu
 * @date '2020-03-22'
 */
public interface SysUserService extends IService<SysUser> {


    List<SysUser>  selectByMaster();


    List<SysUser>  selectBySlaveOne();

    List<SysUser>  selectBySlaveTwo();
}
