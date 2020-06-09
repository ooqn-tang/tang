package net.ttcxy.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = response.getWriter();
        CommonResult<Object> failed = CommonResult.failed("未登陆!");
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(failed));
        out.flush();
        out.close();


    }
}
