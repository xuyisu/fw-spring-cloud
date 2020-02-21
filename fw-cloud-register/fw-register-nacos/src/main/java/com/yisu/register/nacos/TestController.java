package com.yisu.register.nacos;

import com.yisu.feign.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/26
 */
@RestController
public class TestController {
    /**
     * 获取字符串信息
     * @return
     */
    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World!";
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/user")
    public User getUser() {
        return new User(1L,"nacos","test","test@qq.com","演示Nacos 替换Eureka");
    }
}
