package com.ooqn.core.security;

import java.io.IOException;
import java.util.Date;

import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.propertie.TangProperties;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.ooqn.service.UtsAuthorService;

public class JwtFilter extends GenericFilterBean {

	private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UtsAuthorService authorService;

	@Autowired
	private TangProperties tangProperties;

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		if(httpServletRequest.getMethod().equals("OPTIONS")){
			chain.doFilter(request, response);
			return;
		}
		
		String jwt = resolveToken(httpServletRequest);
		String requestURI = httpServletRequest.getRequestURI();



		if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt) && !antPathMatcher.match("/api/refresh", requestURI)) {
			Authentication authentication = jwtProvider.getAuthentication(jwt);
			UtsAuthorDto authorDto = (UtsAuthorDto) authentication.getPrincipal();
			Date date = authorService.nowTime(authorDto.getUsername(), authorDto.getRoleList());
			if (date != null && date.getTime() != authorDto.getRefreshTime()) {
				httpServletResponse.setStatus(666);
				httpServletResponse.getWriter().print("JWT权限刷新了");
				return;
			} else {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			LOG.debug("将身份验证设置为安全的上下文 '{}', uri: {}",
					authentication.getName(), requestURI);
		} else {
			LOG.debug("没有找到有效的JWT令牌, uri: {}", requestURI);
		}

		chain.doFilter(request, response);
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(tangProperties.getTokenKey());
		if (StringUtils.hasText(bearerToken)) {
			return bearerToken;
		}
		return null;
	}
}
