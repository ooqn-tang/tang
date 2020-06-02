package net.ttcxy.tangtang.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.properties.TangTangProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author huanglei
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static String REQUEST_WITH = "X-Requested-With";

    @Autowired
    private TangTangProperties tangTangProperties;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName);
            if (REQUEST_WITH.equalsIgnoreCase(headerName)){
                CommonResult<String> commonResult = CommonResult.failed("未登陆");
                response.setContentType("application/json;charset=utf-8");
                ObjectMapper objectMapper = new ObjectMapper();
                response.getWriter().print(objectMapper.writeValueAsString(commonResult));
                return;
            }
        }
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect(tangTangProperties.getSecurity().getLoginPagePath());
    }
}
