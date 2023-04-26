package com.ooqn.service;

import java.util.List;

import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.dto.UtsRoleDto;
import com.ooqn.entity.model.UtsAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;

/**
 * @description: 用户登录认证信息查询
 */
@Service
public class UtsUserDetailsService implements UserDetailsService {

	@Autowired
	private UtsAuthorService authorService;

	@Autowired
	private UtsRoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtsAuthor author;

		if (Validator.isEmail(username)) {
			author = authorService.selectAuthorByMail(username);
		} else {
			author = authorService.selectAuthorByName(username);
		}

		if (author != null) {
			UtsAuthorDto authorDto = new UtsAuthorDto();
			authorDto.setAuthor(author);
			List<UtsRoleDto> utsRoles = roleService.roleList(author.getAuthorId());
			authorDto.setRoleList(utsRoles);
			return BeanUtil.toBean(authorDto, UtsAuthorDto.class);
		}

		throw new UsernameNotFoundException("输入的用户名或密码不正确");
	}

	public static void main(String[] args) {
		
	}
}
