package com.jnnvc.vblog.security.config;

import com.jnnvc.vblog.security.authentication.MyAuthenticationFailureHandler;
import com.jnnvc.vblog.security.authentication.MyAuthenticationSuccessHandler;
import com.jnnvc.vblog.security.filter.ValidateCodeFilter;
import com.jnnvc.vblog.security.properties.SecurityProperties;
import com.jnnvc.vblog.security.service.impl.MyAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;


    @Bean //注入PsswordEncoder
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //数据表格生成
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)//在拦截器UsernamePasswordAuthenticationFilter前面添加一个拦截器
                .formLogin()//当前配置文件，用于配置浏览器表单登录
                .loginPage("/login.html")//配置登录页面
                .loginProcessingUrl("/doLogin")//登录POST请求
                .successHandler(myAuthenticationSuccessHandler)//自己重写的登录成功处理器
                .failureHandler(myAuthenticationFailureHandler)//自己重写的登录失败处理器
                .and()//结束上一个登录配置，开始“记住我”的配置
                .rememberMe()//允许配置“记住我”身份验证。
                .tokenRepository(persistentTokenRepository())//记住我需要生成在数据库保存token，这个配置用于保存token
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())//token有效时间
                .userDetailsService(userDetailsService())//登录时，如果用户没有登录，去数据库查询token，如果拥有有效token直接免登录使用
                .and()//结束记住我，开始配置那些页面需登录
                //.authorizeRequests().anyRequest().permitAll()//所有人都可以访问
                .authorizeRequests()
                    .antMatchers("/login.html","/require","/doLogin","/code/image",
                            securityProperties.getBrowser().getLoginPage()).permitAll()//antMatchers中的页面需要访问
                //所有经过身份认证的用户可以访问如何url
                .anyRequest().authenticated()
                .and()
                .csrf().disable();//关闭csrf安全
    }


}
