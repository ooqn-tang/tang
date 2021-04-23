package net.ttcxy.tang.gateway.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ttcxy.tang.gateway.core.properties.SecurityProperties;
import net.ttcxy.tang.gateway.core.security.MyAuthenticationEntryPoint;
import net.ttcxy.tang.gateway.core.security.MyAuthenticationFailureHandler;
import net.ttcxy.tang.gateway.core.security.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * SpringSecurity 配置
 * @author huanglei
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 由于本安全框架独立于应用模块，调用的模块需要注入userDetailsService Bean
        http.userDetailsService(userDetailsService);
        // 没有权限的处理器
        http.exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint);
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        http.headers().frameOptions().disable();
        // 登录拦截器前面添加验证码拦截器
        //http.addFilterBefore(myVerifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        // 不需要登录的请求
        http.authorizeRequests().antMatchers(securityProperties.getOpenUrls()).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        // 需要登录的请求
        http.authorizeRequests().anyRequest().authenticated();

        //允许配置“记住我”身份验证。
        if (securityProperties.isRememberMe()) {
            http.rememberMe()
            //记住我需要生成在数据库保存token，这个配置用于保存token
            .tokenRepository(persistentTokenRepository())
            //token有效时间
            .tokenValiditySeconds(securityProperties.getTokenTime())
            //登录时，如果用户没有登录，去数据库查询token，如果拥有有效token直接免登录使用
            .userDetailsService(userDetailsService);
        }

        http
        .formLogin()
        //配置登录页面
        .loginPage(securityProperties.getLoginPagePath())
        //登录POST请求
        .loginProcessingUrl(securityProperties.getFormLoginApi())
        //自己重写的登录成功处理器
        .successHandler(myAuthenticationSuccessHandler)
        //自己重写的登录失败处理器
        .failureHandler(myAuthenticationFailureHandler)

        .and().cors().and()
        //关闭csrf安全
        .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return (request, response, accessDeniedException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().print(objectMapper.writeValueAsString("没有权限"));
        };
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("leilei"));
    }
}