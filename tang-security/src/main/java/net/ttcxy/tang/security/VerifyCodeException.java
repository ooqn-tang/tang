package net.ttcxy.tang.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常处理器
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
