package com.ooqn.entity.dto;

import com.ooqn.entity.model.UtsAuthor;

import java.util.Collection;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@EqualsAndHashCode
public class UtsAuthorDto implements UserDetails {

	private UtsAuthor author;

	private List<UtsRoleDto> roleList;

	public long getRefreshTime() {
		return author.getRefreshTime().getTime();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roleList;
	}

	@Override
	public String getPassword() {
		return author.getPassword();
	}

	@Override
	public String getUsername() {
		return author.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
