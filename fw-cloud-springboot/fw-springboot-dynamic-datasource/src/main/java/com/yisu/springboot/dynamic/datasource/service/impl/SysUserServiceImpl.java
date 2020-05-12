package com.yisu.springboot.dynamic.datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yisu.springboot.dynamic.datasource.mapper.SysUserMapper;
import com.yisu.springboot.dynamic.datasource.model.SysUser;
import com.yisu.springboot.dynamic.datasource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 系统用户表-业务实现
 * @author xuyisu
 * @date '2020-03-22'
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @DS("master")
    @Override
    public List<SysUser> selectByMaster() {
        return sysUserMapper.selectList(null);
    }

    @DS("slave_1")
    @Override
    public List<SysUser> selectBySlaveOne() {
        return sysUserMapper.selectList(null);
    }

    @DS("slave_2")
    @Override
    public List<SysUser> selectBySlaveTwo() {
        return sysUserMapper.selectList(null);
    }
}
