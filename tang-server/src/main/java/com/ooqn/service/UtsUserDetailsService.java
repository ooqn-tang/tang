package com.ooqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;

import cn.hutool.core.lang.Validator;

/**
 * @description: 用户登录认证信息查询
 */
@Service
public class UtsUserDetailsService {

	@Autowired
	private UtsAuthorService authorService;

	@Autowired
	private UtsRoleService roleService;

	public UtsAuthorDto loadUserByUsername(String username)  {
		
		UtsAuthor author;

		if (Validator.isEmail(username)) {
			author = authorService.selectAuthorByMail(username);
		} else {
			author = authorService.selectAuthorByName(username);
		}

		if (author != null) {
			UtsAuthorDto authorDto = new UtsAuthorDto(author);
			List<UtsRole> roles = roleService.roleList(author.getAuthorId());
			authorDto.setRoleList(roles);
			return authorDto;
		}

		throw new ApiException("输入的用户名或密码不正确");
	}

}
