package net.ttcxy.tangtang.security.filter;

import cn.hutool.core.util.StrUtil;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.security.controller.ValidateCodeController;
import net.ttcxy.tangtang.security.exception.ValidateCodeException;
import net.ttcxy.tangtang.security.model.ValidateCode;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 图像验证码连接器
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * url列表
     */
    private Set<String> urls = new HashSet<>();

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 获取session
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StrUtil.splitToArray(securityProperties.getCode().getImage().getUrls(),',');
        for (String url : configUrls){
            urls.add(url);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        for(String url : urls){
            if(pathMatcher.match(url,httpServletRequest.getRequestURI())){
                try{
                    validate(new ServletWebRequest(httpServletRequest));
                }catch(ValidateCodeException e){
                    authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                    return;
                }
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }


    private void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {

        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(servletWebRequest, SessionKey.SESSION_KEY_IMAGE_CODE);

        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),"imageCode");

        if (StrUtil.isBlank(codeInRequest)){
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (codeInSession == null){
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpried()){
            sessionStrategy.removeAttribute(servletWebRequest, SessionKey.SESSION_KEY_IMAGE_CODE);
            throw new ValidateCodeException("验证码过期");
        }

        if (!StrUtil.equals(codeInSession.getCode(),codeInRequest)){
            sessionStrategy.removeAttribute(servletWebRequest,SessionKey.SESSION_KEY_IMAGE_CODE);
            throw new ValidateCodeException("验证码不匹配");
        }

        sessionStrategy.removeAttribute(servletWebRequest,SessionKey.SESSION_KEY_IMAGE_CODE);
    }


    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

}
