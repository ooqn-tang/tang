package net.ttcxy.tang.gateway.code.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常处理器
 * @author huanglei
 */
public class VerifyCodeException extends AuthenticationException {

    public VerifyCodeException(String msg) {
        super(msg);
    }

    public VerifyCodeException(String msg, Throwable t) {
        super(msg, t);
    }
}
