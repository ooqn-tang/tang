package cn.ttcxy.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.ttcxy.entity.StateEnum;
import cn.ttcxy.entity.dto.UtsAuthorDto;
import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsAuthor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtsUserDetailsService implements UserDetailsService {

	@Autowired
	private UtsAuthorService utsAuthorService;

	@Autowired
	private UtsRoleService utsRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtsAuthor author;

		if (Validator.isEmail(username)) {
			author = utsAuthorService.selectAuthorByMail(username);
		} else {
			author = utsAuthorService.selectAuthorByName(username);
		}

		if (author != null) {
			UtsAuthorDto authorDto = new UtsAuthorDto();
			authorDto.setAuthor(author);
			List<UtsRoleDto> utsRoles = utsRoleService.roleList(author.getAuthorId());
			authorDto.setRoleList(utsRoles);
			return BeanUtil.toBean(authorDto, UtsAuthorDto.class);
		}

		throw new UsernameNotFoundException("输入的用户名或密码不正确");
	}

	public static void main(String[] args) {
		
	}
}
