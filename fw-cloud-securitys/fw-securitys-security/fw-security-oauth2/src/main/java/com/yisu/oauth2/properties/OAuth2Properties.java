package com.yisu.oauth2.properties;

import lombok.Data;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Data
public class OAuth2Properties {

    private String jwtSigningKey = "fw";

    private OAuth2ClientProperties[] clients = {};
}
