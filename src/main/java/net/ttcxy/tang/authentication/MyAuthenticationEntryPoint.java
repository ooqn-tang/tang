package net.ttcxy.tang.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.api.ResultCode;
import net.ttcxy.tang.properties.TangProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 这里配置了没有权限的处理器
 * @author huanglei
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static String REQUEST_WITH = "X-Requested-With";

    @Autowired
    private TangProperties tangProperties;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            if (REQUEST_WITH.equalsIgnoreCase(headerName)){
                CommonResult<String> commonResult =  CommonResult.failed(ResultCode.UNAUTHORIZED);
                response.setContentType("application/json;charset=utf-8");
                ObjectMapper objectMapper = new ObjectMapper();
                response.getWriter().print(objectMapper.writeValueAsString(commonResult));
                return;
            }
        }
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect(tangProperties.getSecurity().getLoginPagePath());
    }
}
