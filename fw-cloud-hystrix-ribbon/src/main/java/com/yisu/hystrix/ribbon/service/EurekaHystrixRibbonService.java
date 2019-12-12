package com.yisu.hystrix.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yisu.hystrix.ribbon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author xuyisu
 * @description
 * @date 2019/12/10
 */
@Service
@Slf4j
public class EurekaHystrixRibbonService {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findUserByIdFailure")
    public User findUserById(Long id) {
        // http://服务提供者的serviceId/url
        return restTemplate.getForObject("http://fw-cloud-feign-server/user/" + id, User.class);
    }

    /**
     * 服务 fw-cloud-feign-server/user/id 调用失败的回调方法
     *
     * @return
     */
    public User findUserByIdFailure(Long id) {
        return new User(id,null,null,null,"网络繁忙，请稍后再试,请确认手牌");
    }

}
