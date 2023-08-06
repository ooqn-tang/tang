package com.ooqn.core;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ooqn.core.api.ResponseCode;
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.model.UtsAuthor;

import jakarta.servlet.http.HttpServletRequest;

public class BaseController {

	public String authorId() {
		return author().getAuthorId();
	}

	public String authorName() {
		return author().getUsername();
	}

	public UtsAuthor author() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(servletRequestAttributes != null){
			HttpServletRequest request = servletRequestAttributes.getRequest();
			UtsAuthorDto authorDto = (UtsAuthorDto)request.getAttribute("author");
			return authorDto.getAuthor();
		}
    	throw new ApiException(ResponseCode.UNAUTHORIZED);
	}

}
