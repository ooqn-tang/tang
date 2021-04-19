package net.ttcxy.tang.gateway.code.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tang.gateway.code.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 没有权限的处理器
 * 如果 请求头中包含 X-Requested-With 返回JSON 如果不包含，跳转到登录页面
 * @author huanglei
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().print(objectMapper.writeValueAsString("没有登录或过期"));
    }
}
