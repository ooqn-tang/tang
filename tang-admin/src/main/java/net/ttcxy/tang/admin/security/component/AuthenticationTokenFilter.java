package net.ttcxy.tang.admin.security.component;

import net.ttcxy.tang.entity.dto.UtsAuthorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT登录授权过滤器
 * @author huanglei
 */
@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

    @Value("${tang.security.tokenHeader}")
    private String tokenHeader;

    public static Map<String, UtsAuthorDto> authorDtoMap = new HashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UtsAuthorDto utsAuthorDto = authorDtoMap.get(authHeader);
            LOGGER.info("checking username : {}", utsAuthorDto);
            if (utsAuthorDto != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(utsAuthorDto, null, utsAuthorDto.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                LOGGER.info("authenticated user:{}", utsAuthorDto.getUsername());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
