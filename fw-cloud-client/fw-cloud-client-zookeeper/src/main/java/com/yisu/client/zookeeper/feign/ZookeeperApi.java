package com.yisu.client.zookeeper.feign;

import com.yisu.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/9
 */
@FeignClient(name = "fw-register-zookeeper")
public interface ZookeeperApi {

    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/helloWorld")
    String helloWorld();

    /**
     * 获取用户信息demo
     * @return
     */
    @GetMapping("/user")
    User getUser();

}
