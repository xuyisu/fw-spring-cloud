package com.yisu.client.consul.feign;//package com.yisu.feign.api;

import com.yisu.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/9
 */
@FeignClient(value = "fw-register-consul-server")
public interface ConsulApi {

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
