package cn.ttcxy.core.security;

import cn.ttcxy.entity.CurrentAuthor;
import cn.ttcxy.entity.propertie.TangProperties;
import cn.ttcxy.service.UtsAuthorService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Log
public class JwtFilter extends GenericFilterBean {

    private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private TangProperties tangProperties;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String jwt = resolveToken(httpServletRequest);
        String requestURI = httpServletRequest.getRequestURI();

        if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt) && !antPathMatcher.match("/api/refresh",requestURI)) {
            Authentication authentication = jwtProvider.getAuthentication(jwt);
            CurrentAuthor currentAuthor = (CurrentAuthor) authentication.getPrincipal();
            Date date = authorService.nowTime(currentAuthor.getUsername(), currentAuthor.getRoles());
            if (date != null && date.getTime() != currentAuthor.getRefreshTime()){
                httpServletResponse.setStatus(666);
                httpServletResponse.getWriter().print("JWT权限刷新了");
                return;
            }else{
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            LOG.debug("set Authentication to security context for '{}', uri: {}", authentication.getName(), requestURI);
        } else {
            LOG.debug("no valid JWT token found, uri: {}", requestURI);
        }

        chain.doFilter(request, response);
    }


    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(tangProperties.getTokenKey());
        if (StringUtils.hasText(bearerToken)) {
            return bearerToken;
        }
        return null;
    }
}
