package com.yisu.client.zookeeper.controller;

import com.yisu.client.zookeeper.feign.ZookeeperApi;
import com.yisu.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xuyisu
 * @description 测试zk注册中心
 * @date 2019/12/9
 */
@RestController
public class ZookeeperController {

    @Autowired
    private ZookeeperApi zookeeperApi;

    /**
     * hello word
     * @return
     */
    @GetMapping("/hello")
    public String hello() {

        return zookeeperApi.helloWorld();

    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public User getUser() {
        return zookeeperApi.getUser();

    }
}
