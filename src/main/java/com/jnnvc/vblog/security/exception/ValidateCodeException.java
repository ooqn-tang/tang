package com.jnnvc.vblog.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 */
public class ValidateCodeException extends AuthenticationException {


    private static final long serialVersionUID = -1209418415622965838L;

    public ValidateCodeException(String detail) {
        super(detail);
    }
}


