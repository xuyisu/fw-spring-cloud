package com.yisu.actuator.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author xuyisu
 * @description 健康检查处理器
 * @date 2019/12/21
 */
@Component
@Slf4j
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        if(myHealthIndicator.health().getStatus().equals(Status.UP)){
            log.info("第三方服务可以正常访问");
            return InstanceInfo.InstanceStatus.UP;
        }else{
            log.info("第三方服务访问异常");
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
