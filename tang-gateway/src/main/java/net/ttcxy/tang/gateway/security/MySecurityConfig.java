package net.ttcxy.tang.gateway.security;

import net.ttcxy.tang.security.config.SessionSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * SpringSecurity 配置
 * created by huanglei on 2020/10/10
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends SessionSecurityConfig {

    @Autowired
    private LoginUserService loginUserService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> loginUserService.loadUserByUsername(username);
    }
}
