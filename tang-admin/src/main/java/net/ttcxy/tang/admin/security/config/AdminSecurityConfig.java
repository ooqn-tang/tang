package net.ttcxy.tang.admin.security.config;

import net.ttcxy.tang.admin.security.component.*;
import net.ttcxy.tang.code.properties.SecurityProperties;
import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.service.UtsMemberService;
import net.ttcxy.tang.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 对SpringSecurity的配置的扩展，支持自定义白名单资源路径和查询用户逻辑
 * @author huanglei
 * @date 2019/11/5
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DynamicSecurityFilter dynamicSecurityFilter;

    @Autowired
    private UtsMemberService utsMemberService;

    @Autowired
    private UtsResourceService utsResourceService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationTokenFilter authenticationTokenFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        // 不需要保护的资源路径允许访问
        for (String url : securityProperties.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        // 允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();

        // 任何请求需要身份认证
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 动态权限配置时添加动态权限校验过滤器
        registry.and().addFilterBefore(dynamicSecurityFilter, FilterSecurityInterceptor.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            Map<String, Collection<ConfigAttribute>> map = new ConcurrentHashMap<>();
            List<UtsResourceDto> resourceList = utsResourceService.listAll();
            for (UtsResourceDto resource : resourceList) {
                Set<ConfigAttribute> configAttributeSet = new HashSet<>();
                for (UtsRoleDto utsRoleDto : resource.getRoleDtoList()) {
                    configAttributeSet.add(new SecurityConfig(utsRoleDto.getAuthority()));
                }
                map.put(resource.getPath(),configAttributeSet);
            }
            return map;
        };
    }


}
