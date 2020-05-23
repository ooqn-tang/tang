package net.ttcxy.tangtang.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tangtang.properties.TangTangProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败返回JSON
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TangTangProperties tangTangProperties;

    public MyAuthenticationFailureHandler(){
        this.setDefaultFailureUrl("/login.html?error=true");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {

        super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);

    }
}
