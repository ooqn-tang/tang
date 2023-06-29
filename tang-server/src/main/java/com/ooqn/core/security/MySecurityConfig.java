package com.ooqn.core.security;

import java.util.Collection;
import java.util.List;

import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.propertie.TangProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
import org.springframework.web.filter.CorsFilter;

import com.ooqn.service.UtsResourceService;

@Configuration
public class MySecurityConfig {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private TangProperties tangProperties;

    @Autowired
    private UtsResourceService utsResourceService;

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        String[] split = tangProperties.getOpenUrl().split(",");
        return web -> web
                .ignoring()
                .requestMatchers(HttpMethod.OPTIONS, "/**")
                .requestMatchers(split);
    }

    @Bean
    SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint(MyAuthenticationEntryPoint())
                        .accessDeniedHandler(MyAccessDeniedHandler()))
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests()
                .anyRequest().access((authenticationSupplier, requestAuthorizationContext) -> {
                    Collection<? extends GrantedAuthority> authorities = authenticationSupplier.get().getAuthorities();
                    HttpServletRequest request = requestAuthorizationContext.getRequest();
                    boolean isGranted = true;
                    for (GrantedAuthority authority : authorities) {
                        String role = authority.getAuthority();
                        List<UtsResource> resourceList = utsResourceService.loadResourceUrlByRoleValue(role);
                        for (UtsResource resource : resourceList) {
                            String method = request.getMethod();
                            if (antPathMatcher.match(resource.getPath(), request.getRequestURI()) && method.equals(resource.getType())) {
                            }
                        }
                    }
                    return new AuthorizationDecision(isGranted);
                });

        http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable);

        http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();

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
        // 创建CorsConfiguration实例
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有域名进行跨域调用
        config.addAllowedOriginPattern("*");
        // 允许跨越发送cookie
        config.setAllowCredentials(true);
        // 放行全部原始头信息
        config.addAllowedHeader("*");
        // 允许所有请求方法跨域调用
        config.addAllowedMethod("*");
        // 创建UrlBasedCorsConfigurationSource实例
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 将config中的配置属性添加到source中
        source.registerCorsConfiguration("/**", config);
        // 返回CorsFilter实例
        return new CorsFilter(source);
    }
}
