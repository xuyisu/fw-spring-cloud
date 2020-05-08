package com.yisu.starter.sample.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "fwcloud.sample")
public class SampleProperties {

    /**
     * 开关
     */
    boolean enable = false;

    /**
     * 获取配置的用户
     */
    String user;
}
