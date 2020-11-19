package net.ttcxy.tang.gateway.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理器
 * @author huanglei
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException exception) throws IOException {
        // TODO 需要修改为异步FROM表单登陆
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(400);
        httpServletResponse.getWriter().append(exception.getMessage());
    }
}
