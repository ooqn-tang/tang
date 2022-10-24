package cn.ttcxy.core.security;

import cn.ttcxy.entity.propertie.TangProperties;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MySecurityConfig {

	@Autowired
	private TangProperties tangProperties;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
				.antMatchers(tangProperties.getOpenUrl().split(","));
	}

	@Bean
	SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
		http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().authenticationEntryPoint(MyAuthenticationEntryPoint())
				.accessDeniedHandler(MyAccessDeniedHandler()).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.anyRequest().access("@utsRbacService.hasPermission(request,authentication)").and()
				.cors().disable().csrf().disable();

		return http.build();
	}

	@Bean
	AuthenticationEntryPoint MyAuthenticationEntryPoint() {
		return (request, response, authException) -> response
				.sendError(HttpServletResponse.SC_FORBIDDEN, authException.getMessage());
	}

	@Bean
	AccessDeniedHandler MyAccessDeniedHandler() {
		return (request, response, accessDeniedException) -> response
				.sendError(HttpServletResponse.SC_UNAUTHORIZED, accessDeniedException.getMessage());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	JwtFilter jwtFilter() {
		return new JwtFilter();
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		// 允许所有域名进行跨域调用
		config.addAllowedOriginPattern("*");
		// 允许跨越发送cookie
		config.setAllowCredentials(true);
		// 放行全部原始头信息
		config.addAllowedHeader("*");
		// 允许所有请求方法跨域调用
		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
