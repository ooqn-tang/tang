package cn.ttcxy.core.security;

import cn.ttcxy.service.UtsAuthorService;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtProvider;

    private final UtsAuthorService authorService;

    public JwtConfig(JwtProvider jwtProvider, UtsAuthorService authorService) {
        this.jwtProvider = jwtProvider;
        this.authorService = authorService;
    }

    public void configure(HttpSecurity http) {
        JwtFilter customFilter = new JwtFilter(jwtProvider,authorService);

        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
