package net.ttcxy.tang.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 由于本安全框架独立于应用模块，调用的模块需要注入userDetailsService Bean
        http.userDetailsService(userDetailsService());
        // 没有权限的处理器
        http.exceptionHandling().authenticationEntryPoint(getMyAuthenticationEntryPoint());
        // 登录拦截器前面添加验证码拦截器
        http.addFilterBefore(getMyVerifyCodeFilter(), UsernamePasswordAuthenticationFilter.class);
        //允许配置“记住我”身份验证。
        if (securityProperties().isRememberMe()) {
            http.rememberMe()
                    //记住我需要生成在数据库保存token，这个配置用于保存token
                    .tokenRepository(persistentTokenRepository())
                    //token有效时间
                    .tokenValiditySeconds(securityProperties().getTokenTime())
                    //登录时，如果用户没有登录，去数据库查询token，如果拥有有效token直接免登录使用
                    .userDetailsService(userDetailsService());
        }
        // 指定url需要登陆，解决和下面配置冲突，（配置顺序靠前优先级高，这些URL即使被下面通配符匹配了，也需要登陆，
        // 比如/user/** 不需要登陆，但是/user/admin需要登陆）
        String[] privateUrl = securityProperties().getPrivateUrl().split(",");
        http.authorizeRequests().antMatchers(privateUrl).authenticated();
        //指定url不需要登陆
        String[] openUrl = securityProperties().getOpenUrl().split(",");
        http.authorizeRequests().antMatchers(openUrl).permitAll();
        //指定所有页面需要登录
        http.authorizeRequests().antMatchers("/**").authenticated();
        http
                .formLogin()
                //配置登录页面
                .loginPage(securityProperties().getLoginPagePath())
                //登录POST请求
                .loginProcessingUrl(securityProperties().getFormLoginApi())
                //自己重写的登录成功处理器
                .successHandler(myAuthenticationSuccessHandler())
                //自己重写的登录失败处理器
                .failureHandler(myAuthenticationFailureHandler())
                //结束上一个登录配置，开始“记住我”的配置
                .and()
                //关闭csrf安全
                .csrf().disable();
    }

    /**
     * 查询登录的用户
     * @return UserDetailsService
     */
    @Override
    public UserDetailsService userDetailsService() {
        return username -> userDetailsServiceImpl.loadUserByUsername(username);
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
    public MyAuthenticationEntryPoint getMyAuthenticationEntryPoint(){
        return new MyAuthenticationEntryPoint();
    }
    @Bean
    public MyVerifyCodeFilter getMyVerifyCodeFilter(){
        return new MyVerifyCodeFilter();
    }
    @Bean
    public SecurityProperties securityProperties(){
        return new SecurityProperties();
    }
    @Bean
    public MyAuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyAuthenticationSuccessHandler();
    }
    @Bean
    public MyAuthenticationFailureHandler myAuthenticationFailureHandler(){
        return new MyAuthenticationFailureHandler();
    }
}
