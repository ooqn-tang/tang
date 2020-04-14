package net.ttcxy.tangtang.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录成功返回JSON
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {



    @Autowired
    private HttpSession httpSession;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        //获取登录的用户
        Object principal = authentication.getPrincipal();
        httpSession.setAttribute(SessionKey.LOGIN_USER_SESSION_KEY,principal);

        super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);

    }
}
