package com.ooqn.core.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooqn.core.config.TangConfig;
import com.ooqn.core.exception.ApiException;
import com.ooqn.core.propertie.TangProperties;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.model.UtsRole;
import com.ooqn.service.UtsResourceService;
import com.ooqn.service.UtsUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

	private JwtProvider jwtProvider;

	private UtsUserDetailsService userDetailsService;

	private UtsResourceService resourceService;

	private TangProperties tangProperties;

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	public JwtFilter(JwtProvider jwtProvider, UtsUserDetailsService userDetailsService,
			UtsResourceService resourceService, TangProperties tangProperties) {
		this.jwtProvider = jwtProvider;
		this.userDetailsService = userDetailsService;
		this.resourceService = resourceService;
		this.tangProperties = tangProperties;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (whiteUrlHeader(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		String jwt = resolveJwt(request);
		String requestURI = request.getRequestURI();

		if (jwtProvider.validateJwt(jwt)) {
			String username = jwtProvider.getAuthentication(jwt);
			UtsAuthor author = userDetailsService.loadUserByUsername(username);
			List<UtsRole> roles = userDetailsService.loadRoles(username);
			request.setAttribute("author", author);
			request.setAttribute("roles", roles);

			for (UtsRole role : roles) {
				String roleId = role.getRoleId();
				List<UtsResource> resources = resourceService.selectByRoleId(roleId);

				// 角色是否有权限
				for (UtsResource resource : resources) {
					String path = resource.getPath();
					if (antPathMatcher.match(path, requestURI)) {
						filterChain.doFilter(request, response);
						return;
					}
				}
			}
		}
		LOG.debug("没有找到有效的JWT令牌, uri: {}", requestURI);
		returnResponse(request, response, new ApiException(400,"没有权限。"));
	}

	private String resolveJwt(HttpServletRequest request) {
		String bearerJwt = request.getHeader(tangProperties.getTokenKey());
		if (StringUtils.hasText(bearerJwt)) {
			return bearerJwt;
		}
		return null;
	}

	private boolean whiteUrlHeader(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String method = request.getMethod().toLowerCase();

		if (method.equals("options")) {
			return true;
		}

		String[] split = tangProperties.getOpenUrl().split(",");
		for (String string : split) {
			if (antPathMatcher.match(string, requestURI)) {
				return true;
			}
		}

		for (Map<String, String> map : TangConfig.whiteUrl) {
			String pathVal = map.get("path");
			String methodVal = map.get("method");

			if (methodVal != null) {
				methodVal = methodVal.toLowerCase();
				if (antPathMatcher.match(pathVal, requestURI) && method.equals(methodVal)) {
					return true;
				}
			} else {
				if (antPathMatcher.match(pathVal, requestURI)) {
					return true;
				}
			}

		}
		return false;
	}

	private static final ObjectMapper mapper = new ObjectMapper();

	private void returnResponse(HttpServletRequest request, HttpServletResponse response, ApiException exception){
		PrintWriter writer = null;
		response.setContentType("application/json; charset=UTF-8");
		// 设置CORS头
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Content-Type", "application/json");
		response.setStatus(exception.getStatus());
		try {
			writer = response.getWriter();
			Map<String,String> map = new HashMap<>();
			map.put("message", exception.getMessage());
			String json = mapper.writeValueAsString(map);
			writer.write(json);
		} catch (IOException e) {
			LOG.error("response error", e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}


}
