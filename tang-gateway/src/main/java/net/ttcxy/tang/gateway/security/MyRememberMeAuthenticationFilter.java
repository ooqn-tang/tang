package net.ttcxy.tang.gateway.security;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 如果想对记住我进行特殊操作可以在这实现你需要的功能
 * created by huanglei on 2020/09/09
 */
public class MyRememberMeAuthenticationFilter extends RememberMeAuthenticationFilter {

    public MyRememberMeAuthenticationFilter(AuthenticationManager authenticationManager, RememberMeServices rememberMeServices) {
        super(authenticationManager, rememberMeServices);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }

    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
        super.onSuccessfulAuthentication(request, response, authResult);
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        super.onUnsuccessfulAuthentication(request, response, failed);
    }

    @Override
    public RememberMeServices getRememberMeServices() {
        return super.getRememberMeServices();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        super.setApplicationEventPublisher(eventPublisher);
    }


    @Override
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }
}
