package net.ttcxy.tang.security;

import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.properties.TangProperties;
import net.ttcxy.tang.security.exception.VerifyCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyVerifyCodeFilter extends OncePerRequestFilter {

    private Set<String> urls = new HashSet<>();

    @Autowired
    private TangProperties tangProperties;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        String verifyUri = tangProperties.getSecurity().getVerifyUri();
        if (StrUtil.isNotBlank(verifyUri)){
            urls.addAll(Arrays.asList(verifyUri.split(",")));
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String remoteHost = request.getRequestURI();
        String verify = ServletRequestUtils.getStringParameter(request, "verify");
        String verifyCode = (String) request.getSession().getAttribute("verify_code");

        for (String url : urls) {
            if (url.equals(remoteHost)){
                if (StrUtil.equals(verifyCode,verify)){
                    request.getSession().removeAttribute("verify_code");
                    break;
                }else{
                    myAuthenticationFailureHandler.onAuthenticationFailure(request,response,new VerifyCodeException("验证码不正确"));
                    return;
                }
            }
        }
        super.doFilter(request,response,filterChain);
    }
}