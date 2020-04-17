package com.yisu.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author xuyisu
 *
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 *
	 */
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
