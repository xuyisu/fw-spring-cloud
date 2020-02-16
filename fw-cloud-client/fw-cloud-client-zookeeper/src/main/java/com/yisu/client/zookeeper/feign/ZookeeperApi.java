package com.yisu.client.zookeeper.feign;

import com.yisu.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/9
 */
@Configuration
@FeignClient(name = "fw-register-zookeeper")
public interface ZookeeperApi {

    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/helloWorld")
    @ResponseBody
    String helloWorld();

    /**
     * 获取用户信息demo
     * @return
     */
    @GetMapping("/user")
    @ResponseBody
    User getUser();

}
