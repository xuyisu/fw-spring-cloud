package com.yisu.feign.without.service;

import com.yisu.feign.without.entity.User;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @description  测试不在SpringCloud项目里使用Feign
 * @author xuyisu
 * @date 2019/12/29
 */
public interface HelloClient {

    @RequestLine("GET /hello")
    String hello();

    @RequestLine("GET /{id:\\d+}")
    User getUserById(@Param("id") Long id);

    @RequestLine("POST /getUsers")
    List<User> getUsers();
}
