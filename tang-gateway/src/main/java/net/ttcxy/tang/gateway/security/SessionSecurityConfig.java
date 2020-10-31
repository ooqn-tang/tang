package net.ttcxy.tang.gateway.security;

import net.ttcxy.tang.gateway.security.MyAuthenticationEntryPoint;
import net.ttcxy.tang.gateway.security.MyAuthenticationFailureHandler;
import net.ttcxy.tang.gateway.security.MyAuthenticationSuccessHandler;
import net.ttcxy.tang.gateway.security.MyVerifyCodeFilter;
import net.ttcxy.tang.gateway.security.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 基于Session的安全配置文件
 * 继承本接口 必须实现 重写userDetailsService()
 * @author huanglei
 */
public class SessionSecurityConfig extends WebSecurityConfigurerAdapter {


}
