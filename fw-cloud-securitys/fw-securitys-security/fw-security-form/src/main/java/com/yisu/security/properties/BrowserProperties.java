/**
 *
 */
package com.yisu.security.properties;

import com.yisu.security.enums.LoginResponseType;
import lombok.Data;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Data
public class BrowserProperties {


	private String loginPage = "/default-login.html";


	private LoginResponseType loginType = LoginResponseType.JSON;



}
