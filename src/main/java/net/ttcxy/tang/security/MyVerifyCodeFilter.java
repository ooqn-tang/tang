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

/**
 * created by HuangLei on 2020/9/20
 */
public class MyVerifyCodeFilter extends OncePerRequestFilter {

    private static final Set<String> URLS = new HashSet<>();

    @Autowired
    private TangProperties tangProperties;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        String verifyUri = tangProperties.getSecurity().getVerifyUri();
        if (StrUtil.isNotBlank(verifyUri)){
            URLS.addAll(Arrays.asList(verifyUri.split(",")));
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String remoteHost = request.getRequestURI();
        String verify = ServletRequestUtils.getStringParameter(request, "verify");
        String verifyCode = (String) request.getSession().getAttribute(MySecurityContext.VERIFY_CODE);

        for (String url : URLS) {
            if (url.equals(remoteHost)){
                if (verifyCode != null && StrUtil.equals(verifyCode,verify)){
                    request.getSession().removeAttribute(MySecurityContext.VERIFY_CODE);
                    break;
                }else{
                    myAuthenticationFailureHandler.onAuthenticationFailure(request,response,new VerifyCodeException("验证码不正确"));
                    request.getSession().removeAttribute(MySecurityContext.VERIFY_CODE);
                    return;
                }
            }
        }
        super.doFilter(request,response,filterChain);
    }
}