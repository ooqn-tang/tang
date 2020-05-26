package net.ttcxy.tangtang.config;

import net.ttcxy.tangtang.authentication.MyAuthenticationFailureHandler;
import net.ttcxy.tangtang.authentication.MyAuthenticationSuccessHandler;
import net.ttcxy.tangtang.properties.TangTangProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.*;

import javax.sql.DataSource;

/**
 * SpringSecurity 配置
 * @author huanglei
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TangTangProperties tangTangProperties;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;


    /**
     * 注入PasswordEncoder
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许配置“记住我”身份验证。
        if (tangTangProperties.getSecurity().isRememberMe()){
            http.rememberMe()
            //记住我需要生成在数据库保存token，这个配置用于保存token
            .tokenRepository(persistentTokenRepository())
            //token有效时间
            .tokenValiditySeconds(tangTangProperties.getSecurity().getTokenTime())
            //登录时，如果用户没有登录，去数据库查询token，如果拥有有效token直接免登录使用
            .userDetailsService(userDetailsService);
        }

        //指定url需要登陆，解决和下面配置冲突，（顺序考前优先级高）
        String[] privateUrl = tangTangProperties.getSecurity().getPrivateUrl().split(",");
        http.authorizeRequests().antMatchers(privateUrl).authenticated();

        //指定url不需要登陆
        String[] openUrl = tangTangProperties.getSecurity().getOpenUrl().split(",");
        http.authorizeRequests().antMatchers(openUrl).permitAll();

        //指定所有页面需要登录
        http.authorizeRequests().antMatchers("/**").authenticated();

        http
            .formLogin()
            //配置登录页面
            .loginPage(tangTangProperties.getSecurity().getLoginPagePath())
            //登录POST请求
            .loginProcessingUrl(tangTangProperties.getSecurity().getFormLoginApi())
            //自己重写的登录成功处理器
            .successHandler(myAuthenticationSuccessHandler)
            //自己重写的登录失败处理器
            .failureHandler(myAuthenticationFailureHandler)
            //结束上一个登录配置，开始“记住我”的配置
        .and()
        //关闭csrf安全
        .csrf().disable();
    }
}