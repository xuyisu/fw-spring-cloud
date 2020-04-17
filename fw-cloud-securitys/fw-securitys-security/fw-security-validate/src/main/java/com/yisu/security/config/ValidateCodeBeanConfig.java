/**
 *
 */
package com.yisu.security.config;

import com.yisu.security.properties.SecurityProperties;
import com.yisu.security.service.ValidateCodeService;
import com.yisu.security.service.impl.ValidateCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 *
 */
@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeService imageValidateCodeGenerator() {
		ValidateCodeServiceImpl codeGenerator = new ValidateCodeServiceImpl();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}



}
