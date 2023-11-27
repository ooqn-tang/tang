package com.ooqn.core.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    @Nullable
    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            @Nullable Object arg2,
            Exception ex) {
        // 设置响应状态码
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        // 设置响应内容类型为 JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // 创建要返回的错误信息
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", HttpServletResponse.SC_BAD_REQUEST);
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", request.getRequestURI());

        // 使用 Jackson 将错误信息转换为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(errorDetails);
            response.getWriter().write(json);
        } catch (IOException e) {
            // 在这里处理 ObjectMapper 错误
        }

        // 返回空的 ModelAndView 表示响应已经处理
        return new ModelAndView();
    }

}
