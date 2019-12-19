package com.yisu.config.amqp.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/17
 */
@RestController
@RefreshScope //开启更新功能
@RequestMapping("api")
@Slf4j
public class TestController {


    @Value("${version}")
    private String versionValue;

    /**
     * 返回配置文件中的值
     */
    @GetMapping("/version")
    @ResponseBody
    public String returnFormValue(){
        log.debug("输出信息{}",versionValue);
        return versionValue;
    }


}
