package net.ttcxy.tang.gateway.security.exception;

import org.springframework.security.core.AuthenticationException;


/**
 * created by HuangLei on 2020/9/20
 */
public class VerifyCodeException extends AuthenticationException {

    public VerifyCodeException(String msg) {
        super(msg);
    }

    public VerifyCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}
