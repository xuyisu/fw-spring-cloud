package com.yisu.actuator.controller;

import com.yisu.actuator.config.HealthStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description 模拟是否可与第三方访问
 * @date 2019/12/21
 */
@RestController
@Slf4j
public class MyHealthController {

    @PostMapping("/healthStatus")
    public ResponseEntity<String> healthStatus(boolean isHealth){
        HealthStatus.isVisited=isHealth;
        log.info("当前与第三方连接是否可用,{}",isHealth);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
