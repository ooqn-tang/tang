package net.ttcxy.tangtang.security.config;

import net.ttcxy.tangtang.security.authentication.MyAuthenticationFailureHandler;
import net.ttcxy.tangtang.security.authentication.MyAuthenticationSuccessHandler;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
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
 * @author huanglei
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;


    /**
     * 注入PsswordEncoder
     * @return 注入PsswordEncoder
     */
    @Bean
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

        http
                .formLogin()
                //配置登录页面
                .loginPage("/authentication/require")
                //登录POST请求
                .loginProcessingUrl("/authentication/form")
                //自己重写的登录成功处理器
                .successHandler(myAuthenticationSuccessHandler)
                //自己重写的登录失败处理器
                .failureHandler(myAuthenticationFailureHandler)
                //结束上一个登录配置，开始“记住我”的配置
                .and()
                //允许配置“记住我”身份验证。
                .rememberMe()
                //记住我需要生成在数据库保存token，这个配置用于保存token
                .tokenRepository(persistentTokenRepository())
                //token有效时间
                .tokenValiditySeconds(2592000)
                //登录时，如果用户没有登录，去数据库查询token，如果拥有有效token直接免登录使用
                .userDetailsService(userDetailsService)
                //结束上一个配置
                .and()
                //指定页面需要登录
                .authorizeRequests().antMatchers(securityProperties.getIntercept()).authenticated()
                //结束上一个配置
                .and()
                //所有人都可以访问
                .authorizeRequests().anyRequest().permitAll()
                //结束上一个配置
                .and()
                //关闭csrf安全
                .csrf().disable().headers().frameOptions().disable();;


    }


}
