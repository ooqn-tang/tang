package com.ooqn.entity.dto;

import org.springframework.security.core.GrantedAuthority;

import com.ooqn.entity.model.UtsRole;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 */
@Getter
@Setter
public class UtsRoleDto implements GrantedAuthority {

	private UtsRole role;

	@Override
	public String getAuthority() {
		return role.getRoleValue();
	}
}
