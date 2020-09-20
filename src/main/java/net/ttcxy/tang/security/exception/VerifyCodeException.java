package net.ttcxy.tang.security.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


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
