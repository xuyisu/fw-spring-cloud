package com.yisu.oauth2.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class OAuth2CoreConfig {
}
