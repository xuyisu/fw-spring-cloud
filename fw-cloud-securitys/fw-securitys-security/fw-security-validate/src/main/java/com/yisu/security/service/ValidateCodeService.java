package com.yisu.security.service;

import com.yisu.security.model.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author xuyisu
 *
 */
public interface ValidateCodeService {
	/**
	 * 生成验证码
	 * @param request
	 * @return
	 */
	ValidateCode generate(ServletWebRequest request);

	/**
	 * 验证结果
	 */
    void  validate(ServletWebRequest request);

}
