package net.ttcxy.tang.portal.core.security.config;

import net.ttcxy.tang.portal.core.security.jwt.JwtAccessDeniedHandler;
import net.ttcxy.tang.portal.core.security.jwt.JwtAuthenticationEntryPoint;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint authenticationErrorHandler;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final UtsAuthorService authorService;

    public WebSecurityConfig(
            TokenProvider tokenProvider,
            CorsFilter corsFilter,
            JwtAuthenticationEntryPoint authenticationErrorHandler,
            JwtAccessDeniedHandler jwtAccessDeniedHandler,
            UtsAuthorService authorService
    ) {
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.authenticationErrorHandler = authenticationErrorHandler;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.authorService = authorService;
    }

    // Configure BCrypt password encoder =====================================================================

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure paths and requests that should be ignored by Spring Security ================================

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")

                // allow anonymous resource requests
                .antMatchers(
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/h2-console/**",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/swagger-resources",
                        "/v3/api-docs",
                        "/**/*.jpg",
                        "/**/*.*"
                );
    }

    // Configure security settings ===========================================================================

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling()
                .authenticationEntryPoint(authenticationErrorHandler)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // enable
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                // 关闭SESSION
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/authenticate","/api/refresh").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/activate").permitAll()
                .antMatchers("/api/account/reset-password/init").permitAll()
                .antMatchers("/api/account/reset-password/finish").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().access("@utsRbacService.hasPermission(request,authentication)")
                .and()
                .apply(securityConfigurerAdapter());
    }

    private JWTConfig securityConfigurerAdapter() {
        return new JWTConfig(tokenProvider, authorService);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456789"));
    }
}
