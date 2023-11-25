package com.ooqn.core.security;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

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
public class JwtFilter extends OncePerRequestFilter  {

	private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UtsUserDetailsService userDetailsService;

	@Autowired
	private UtsResourceService resourceService;
	@Autowired
	private TangProperties tangProperties;

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();


	private String resolveJwt(HttpServletRequest request) {
		String bearerJwt = request.getHeader(tangProperties.getTokenKey());
		if (StringUtils.hasText(bearerJwt)) {
			return bearerJwt;
		}
		return null;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		// 不需要认证的资源
		if(notLoginRequest(request)){
			filterChain.doFilter(request, response);
			return;
		}

		String jwt = resolveJwt(httpServletRequest);
		String requestURI = httpServletRequest.getRequestURI();

		if (jwtProvider.validateJwt(jwt)) {
			String username = jwtProvider.getAuthentication(jwt);
			UtsAuthor author = userDetailsService.loadUserByUsername(username);
			List<UtsRole> roles = userDetailsService.loadRoles(username);
			request.setAttribute("author", author);
			request.setAttribute("roles", roles);

			if (notRoleRequest(request)) {
				filterChain.doFilter(request, response);
				return;
			}

			for (UtsRole role : roles) {
				String roleId = role.getRoleId();
				List<UtsResource> resources = resourceService.selectByRoleId(roleId);
				
				// 角色是否有权限
				for(UtsResource resource : resources){
					String path = resource.getPath();
					if(antPathMatcher.match(path, requestURI)){
						filterChain.doFilter(request, response);
						return;
					}
				}
			}

			
			LOG.debug("将身份验证设置为安全的上下文 '{}', uri: {}", author.getUsername(), requestURI);
		} else {
			LOG.debug("没有找到有效的JWT令牌, uri: {}", requestURI);
			throw new ApiException(400,"JWT无效。");
		}
		throw new ApiException(400,"没有权限");
	}

	
	private boolean notLoginRequest(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String method = request.getMethod().toLowerCase();

		if(method.equals("options")){
			return true;
		}
		
		String[] split = tangProperties.getOpenUrl().split(",");
		for (String string : split) {
			if (antPathMatcher.match(string, requestURI)) {
				return true;
			}
		}

        return false;
    }

	private boolean notRoleRequest(HttpServletRequest request){
		String requestURI = request.getRequestURI();
		String method = request.getMethod().toLowerCase();

		for(Map<String,String> map : TangConfig.notRoles){
			String pathVal = map.get("path");
			String methodVal = map.get("method");

			if(methodVal != null){
				methodVal = methodVal.toLowerCase();
				if (antPathMatcher.match(pathVal, requestURI) && method.equals(methodVal)) {
					return true;
				}
			}else{
				if (antPathMatcher.match(pathVal, requestURI)) {
					return true;
				}
			}
		}
		return false;
	}
}
