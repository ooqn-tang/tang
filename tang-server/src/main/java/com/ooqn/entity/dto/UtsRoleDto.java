package com.ooqn.entity.dto;

import java.util.Date;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import com.ooqn.entity.model.UtsRole;

/**
 * 角色
 */
@Data
public class UtsRoleDto implements GrantedAuthority {

	private UtsRole role;

	@Override
	public String getAuthority() {
		return role.getRoleValue();
	}
}
