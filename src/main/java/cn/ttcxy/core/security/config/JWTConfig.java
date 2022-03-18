package cn.ttcxy.core.security.config;

import cn.ttcxy.core.security.filter.JWTFilter;
import cn.ttcxy.service.UtsAuthorService;
import cn.ttcxy.core.security.jwt.TokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;

    private final UtsAuthorService authorService;

    public JWTConfig(TokenProvider tokenProvider, UtsAuthorService authorService) {
        this.tokenProvider = tokenProvider;
        this.authorService = authorService;
    }

    public void configure(HttpSecurity http) {
        JWTFilter customFilter = new JWTFilter(tokenProvider,authorService);

        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
