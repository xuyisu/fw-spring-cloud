package com.yisu.security.sso.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@ConfigurationProperties(prefix = "fw.security")
@Data
public class SecurityProperties {

    private OAuth2Properties oauth = new OAuth2Properties();
}

