package com.ooqn.core;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ooqn.core.api.ResponseCode;
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.model.UtsAuthor;

public class BaseController {

	public String authorId() {
		return author().getAuthorId();
	}

	public String authorName() {
		return author().getUsername();
	}

	public UtsAuthor author() {
		final Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			return ((UtsAuthorDto) authentication.getPrincipal()).getAuthor();
		}
		throw new ApiException(ResponseCode.UNAUTHORIZED);
	}

	public boolean isLogin() {
		final Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getPrincipal() instanceof UserDetails;
	}
}
