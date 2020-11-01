package net.ttcxy.tang.gateway.code.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 基于Session的安全配置文件
 * 继承本接口 必须实现 重写userDetailsService()
 * @author huanglei
 */
public class SessionSecurityConfig extends WebSecurityConfigurerAdapter {


}
