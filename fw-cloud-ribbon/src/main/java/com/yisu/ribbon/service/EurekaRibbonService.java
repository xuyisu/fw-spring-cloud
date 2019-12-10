package com.yisu.ribbon.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/10
 */
@Service
@Slf4j
public class EurekaRibbonService {

    @Value("${eureka.client.service-url.defaultZone}")
    private String defaultZone;

    @Autowired
    RestTemplate restTemplate;

    public String getInfo() {
        String message;
        try {
            message = restTemplate.getForObject(defaultZone+"info", String.class);
            log.info("服务 EUREKA-CLIENT/info 返回信息 : {}" , message);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
}
