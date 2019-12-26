package com.yisu.zipkin.client.service;


import com.yisu.zipkin.client.entity.User;

import java.util.List;

/**
 * @author xuyisu
 * @description 用户service
 * @date 2019/12/11
 */
public interface UserService {

    /**
     * 模拟数据库获取所有用户
     * @return
     */
    List<User> getUsers();

    /**
     * 模拟数据库根据id获取用户
     * @return
     */
    User getUserById(long id);
}
