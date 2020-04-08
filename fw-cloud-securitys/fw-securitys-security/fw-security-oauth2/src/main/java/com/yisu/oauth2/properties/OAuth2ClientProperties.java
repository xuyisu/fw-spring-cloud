package com.yisu.oauth2.properties;

import lombok.Data;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private Integer accessTokenValiditySeconds = 7200;
}
