package com.yisu.security.sso.properties;

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

    private Integer refreshTokenValiditySecond = 60 * 60 * 24 * 15;

    private String redirectUri;

    private String scope = "all";

    private Boolean autoApprove;
}
