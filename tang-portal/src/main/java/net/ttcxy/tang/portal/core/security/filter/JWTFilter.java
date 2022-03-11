package net.ttcxy.tang.portal.core.security.filter;

import lombok.extern.java.Log;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class JWTFilter extends GenericFilterBean {

    private static final Logger LOG = LoggerFactory.getLogger(JWTFilter.class);

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;

    private final UtsAuthorService authorService;

    public JWTFilter(TokenProvider tokenProvider,UtsAuthorService authorService) {
        this.tokenProvider = tokenProvider;
        this.authorService = authorService;
    }
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String jwt = resolveToken(httpServletRequest);
        String requestURI = httpServletRequest.getRequestURI();

        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)&&!antPathMatcher.match("/api/refresh",requestURI)) {
            Authentication authentication = tokenProvider.getAuthentication(jwt);
            CurrentAuthor currentAuthor = (CurrentAuthor) authentication.getPrincipal();
            Date date = authorService.nowTime(currentAuthor.getUsername(), currentAuthor.getUtsRoles());
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
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken)) {
            return bearerToken;
        }
        return null;
    }
}
