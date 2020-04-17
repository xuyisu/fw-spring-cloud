package com.yisu.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @Author xuyisu
 * @Date 2019/10/29
 * @Param
 * @Return
 */
@ConfigurationProperties(prefix = "fw.security")
@Data
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();


}

