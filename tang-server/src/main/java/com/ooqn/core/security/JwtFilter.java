package com.ooqn.core.security;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.propertie.TangProperties;
import com.ooqn.service.UtsAuthorService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter  {

	private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UtsAuthorService authorService;

	@Autowired
	private TangProperties tangProperties;

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();


	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(tangProperties.getTokenKey());
		if (StringUtils.hasText(bearerToken)) {
			return bearerToken;
		}
		return null;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if(shouldIgnoreRequest(request)){
			filterChain.doFilter(request, response);
			return;
		}

		String jwt = resolveToken(httpServletRequest);
		String requestURI = httpServletRequest.getRequestURI();
		
		if(httpServletRequest.getMethod().equals("OPTIONS")){
			filterChain.doFilter(request, response);
			return;
		}

		if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt) && !antPathMatcher.match("/api/refresh", requestURI)) {
			UtsAuthorDto authorDto = jwtProvider.getAuthentication(jwt);
			Date date = authorService.nowTime(authorDto.getAuthor().getUsername(), authorDto.getRoleList());
			if (date != null && date.getTime() != authorDto.getRefreshTime()) {
				httpServletResponse.setStatus(666);
				httpServletResponse.getWriter().print("JWT权限刷新了");
				return;
			} else {
				request.setAttribute("author", authorDto);
			}
			LOG.debug("将身份验证设置为安全的上下文 '{}', uri: {}", authorDto.getAuthor().getUsername(), requestURI);
		} else {
			LOG.debug("没有找到有效的JWT令牌, uri: {}", requestURI);
			throw new ApiException(400,"无权限!");
		}

		filterChain.doFilter(request, response);
		throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
	}

	private boolean shouldIgnoreRequest(HttpServletRequest request) {
		String[] split = tangProperties.getOpenUrl().split(",");
		for (String string : split) {
			if (antPathMatcher.match(string, request.getRequestURI())) {
				return true;
			}
		}
        return false;
    }
}
