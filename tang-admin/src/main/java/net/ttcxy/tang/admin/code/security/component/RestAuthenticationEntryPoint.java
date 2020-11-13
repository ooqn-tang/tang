package net.ttcxy.tang.admin.code.security.component;

import net.ttcxy.tang.api.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义返回结果：未登录或登录过期
 * @author huanglei
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        ResponseResult<?> unauthorized = ResponseResult.unauthorized(authException.getMessage());
        int statusCodeValue = unauthorized.getStatusCodeValue();
        response.setStatus(statusCodeValue);

        response.getWriter().println(unauthorized);
        response.getWriter().flush();
    }
}
