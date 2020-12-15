package net.ttcxy.tang.gateway.security;

import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.gateway.entity.MySecurityData;
import net.ttcxy.tang.code.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 登录给你添加验证码
 * @author huanglei
 */
@Component
public class MyVerifyCodeFilter extends OncePerRequestFilter {

    private static final Set<String> urls = new HashSet<>();

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        urls.addAll(Arrays.asList(securityProperties.getVerifyUri()));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String remoteHost = request.getRequestURI();
        String verify = ServletRequestUtils.getStringParameter(request, "verify");
        String verifyCode = (String) request.getSession().getAttribute(MySecurityData.VERIFY_CODE);

        for (String url : urls) {
            if (url.equals(remoteHost)){
                if (verifyCode != null && StrUtil.equals(verifyCode,verify)){
                    request.getSession().removeAttribute(MySecurityData.VERIFY_CODE);
                    break;
                }else{
                    myAuthenticationFailureHandler.onAuthenticationFailure(request,response,new VerifyCodeException("验证码不正确"));
                    request.getSession().removeAttribute(MySecurityData.VERIFY_CODE);
                    return;
                }
            }
        }
        super. doFilter(request,response,filterChain);
    }
}