package com.ooqn.core.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;

import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.propertie.TangProperties;
import com.ooqn.service.UtsResourceService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class MySecurityConfig {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private TangProperties tangProperties;

    @Autowired
    private UtsResourceService utsResourceService;

    @Bean
    SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {

        String[] split = tangProperties.getOpenUrl().split(",");
        // 增加JwtFilter拦截器
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);

        // 异常处理器
        http.exceptionHandling(headers -> {
            headers.authenticationEntryPoint(MyAuthenticationEntryPoint()).accessDeniedHandler(MyAccessDeniedHandler());
        });

        // session管理
        http.sessionManagement(management -> {
            management.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        // 授权配置
        http.authorizeHttpRequests()
                .requestMatchers(split).permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().access((authenticationSupplier, requestAuthorizationContext) -> {
                    Collection<? extends GrantedAuthority> authorities = authenticationSupplier.get().getAuthorities();
                    HttpServletRequest request = requestAuthorizationContext.getRequest();
                    boolean isGranted = false;
                    for (GrantedAuthority authority : authorities) {
                        String role = authority.getAuthority();
                        List<UtsResource> resourceList = utsResourceService.loadResourceUrlByRoleValue(role);
                        for (UtsResource resource : resourceList) {
                            String method = request.getMethod();
                            if (antPathMatcher.match(resource.getPath(), request.getRequestURI()) && method.equals(resource.getType())) {
                                return new AuthorizationDecision(true);
                            }
                        }
                    }
                    return new AuthorizationDecision(isGranted);
                });

        // 关闭跨站请求防护及不使用session
        http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable);

        // 关闭iframe跨域限制
        http.headers(headers -> headers.frameOptions().sameOrigin().httpStrictTransportSecurity().disable());

        return http.build();
    }

    @Bean
    AuthenticationEntryPoint MyAuthenticationEntryPoint() {
        // 返回一个认证失败的错误信息
        return (request, response, authException) -> response
                .sendError(HttpServletResponse.SC_FORBIDDEN, authException.getMessage());
    }

    @Bean
    AccessDeniedHandler MyAccessDeniedHandler() {
        // 返回401，拒绝访问
        return (request, response, accessDeniedException) -> response
                .sendError(HttpServletResponse.SC_UNAUTHORIZED, accessDeniedException.getMessage());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 创建BCryptPasswordEncoder对象
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtFilter jwtFilter() {
        // 创建JwtFilter实例
        return new JwtFilter();
    }

    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
