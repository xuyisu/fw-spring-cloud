package com.yisu.cache.guava.service;


import com.yisu.cache.guava.entity.User;


/**
 * @author xuyisu
 * @description 用户service
 * @date 2020/01/18
 */
public interface UserService {


    /**
     * 模拟数据库根据id获取用户
     * @return
     */
    User getUserById(long id);
}
