package com.ooqn.service;

import com.ooqn.entity.model.UtsResource;

import java.util.Collection;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

@Service
public class UtsRbacService {

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Autowired
	private UtsResourceService resourceService;

	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			String role = authority.getAuthority();
			List<UtsResource> resourceList = resourceService.loadResourceUrlByRoleValue(role);
			for (UtsResource resource : resourceList) {
				String method = request.getMethod();
				if (antPathMatcher.match(resource.getPath(), request.getRequestURI()) && method.equals(resource.getType())) {
					return true;
				}
			}
		}
		return true;
	}
}
