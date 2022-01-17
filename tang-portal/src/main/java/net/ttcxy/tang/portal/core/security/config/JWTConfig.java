package net.ttcxy.tang.portal.core.security.config;

import net.ttcxy.tang.portal.core.security.filter.JWTFilter;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.service.UtsAuthorService;
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
