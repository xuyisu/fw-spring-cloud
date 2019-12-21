package com.yisu.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author xuyisu
 * @description 自定义健康检查器
 * @date 2019/12/21
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(HealthStatus.isVisited){
            //成功和第三方连接
            return new Health.Builder(Status.UP).build();
        }else {
            //和第三方连接失败
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
