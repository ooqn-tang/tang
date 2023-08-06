package com.ooqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.model.UtsRole;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UtsRbacService {

	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Autowired
	private UtsResourceService resourceService;

	public boolean hasPermission(HttpServletRequest request, UtsAuthorDto authorDto) {
		List<UtsRole> roleList = authorDto.getRoleList();
		for (UtsRole role : roleList) {
			List<UtsResource> resourceList = resourceService.loadResourceUrlByRoleValue(role.getRoleValue());
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
