package com.yisu.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@ConfigurationProperties(prefix = "fw.security")
public class SecurityProperties {
	
	private BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}
}

