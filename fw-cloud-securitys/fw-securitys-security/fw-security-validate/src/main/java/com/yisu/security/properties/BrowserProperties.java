package com.yisu.security.properties;

import com.yisu.security.enums.LoginResponseType;
import lombok.Data;

/**
 *
 * @Author xuyisu
 * @Date 2019/10/29
 * @Param
 * @Return
 */
@Data
public class BrowserProperties {


	private String loginPage = "/default-login.html";


	private LoginResponseType loginType = LoginResponseType.JSON;

	private int rememberMeSeconds = 3600;



}
