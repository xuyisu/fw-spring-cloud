package com.yisu.actuator.config;

import lombok.Data;

/**
 * @author xuyisu
 * @description 健康状态信息
 * @date 2019/12/21
 */
@Data
public class HealthStatus {
    /**
     * 是否是可访问的
     */
    public static boolean isVisited;
}
