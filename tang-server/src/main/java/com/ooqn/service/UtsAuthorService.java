package com.ooqn.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.ooqn.entity.dto.UtsRoleDto;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsAuthorRole;
import com.ooqn.entity.model.UtsRole;
import com.ooqn.entity.param.UtsRoleParam;
import com.ooqn.repository.UtsAuthorRepository;
import com.ooqn.repository.UtsAuthorRoleRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 创作者服务
 */
@Service
@Transactional
public class UtsAuthorService {

	@Autowired
	private UtsAuthorRepository authorRepository;

	@Autowired
	private UtsAuthorRoleRepository authorRoleRepository;

	@Autowired
	private UtsRoleService roleService;

	private static final Map<String, Date> usernameTime = new HashMap<>();

	

	public UtsAuthor selectAuthorByName(String username) {
		return authorRepository.findByUsername(username);
	}

	public UtsAuthor selectAuthorByMail(String mail) {
		return authorRepository.findByMail(mail);
	}

	public UtsAuthor insertAuthor(UtsAuthor author) throws DuplicateKeyException {
		String objectId = IdUtil.objectId();
		author.setAuthorId(objectId);
		String username = getUsername();
		author.setNickname(username);
		author.setUsername(username);

		UtsAuthorRole authorRole = new UtsAuthorRole();
		authorRole.setAuthorRoleId(IdUtil.objectId());
		authorRole.setAuthorId(objectId);
		authorRole.setRoleId("2");
		authorRole.setCreateTime(DateUtil.date());
		authorRoleRepository.save(authorRole);
		return authorRepository.save(author);
	}

	public UtsAuthor update(UtsAuthor author) {
		return authorRepository.save(author);
	}

	public Boolean selectUsernameIsTrue(String username) {
		return authorRepository.countByUsername(username) > 0;
	}

	public Boolean selectNicknameIsTrue(String nickname) {
		return authorRepository.countByNickname(nickname) > 0;
	}

	public Boolean selectMailIsTrue(String mail) {
		return authorRepository.countByMail(mail) > 0;
	}

	public Page<UtsAuthor> selectAuthor(Pageable pageable) {
		return authorRepository.findAll(pageable);
	}

	public List<UtsAuthor> select(String queryData) {
		return authorRepository.findByMailLikeAndUsernameLikeAndNicknameLike(
				"%" + queryData + "%", "%" + queryData + "%", "%" + queryData + "%");
	}

	public void delete(String authorId) {
		UtsAuthor author = authorRepository.findById(authorId).orElseThrow();
		authorRepository.save(author);
	}

	public void insertRole(String authorId, List<UtsRoleParam> roleParams) {
		authorRoleRepository.deleteByAuthorId(authorId);
		for (UtsRoleParam roleParam : roleParams) {
			UtsAuthorRole authorRole = new UtsAuthorRole();
			authorRole.setAuthorRoleId(IdUtil.objectId());
			authorRole.setRoleId(roleParam.getRoleId());
			authorRole.setCreateTime(new Date());
			authorRole.setAuthorId(authorId);
			authorRoleRepository.save(authorRole);
		}
	}

	public Date nowTime(String username, List<UtsRoleDto> roleList) {
		Set<Date> dateSet = new TreeSet<>();
		Date usernameTime = getUsernameTime(username);
		if (usernameTime != null) {
			dateSet.add(usernameTime);
		}
		dateSet.addAll(getRoleNameTime(roleList));

		return dateSet.stream().reduce((first, second) -> second).orElse(new Date());
	}

	private Date getUsernameTime(String username) {
		Date date = usernameTime.get(username);
		if (ObjectUtil.isEmpty(date)) {
			UtsAuthor author = selectAuthorByName(username);
			date = author.getRefreshTime();
			usernameTime.put(username, date);
		}
		return date;
	}

	private Set<Date> getRoleNameTime(List<UtsRoleDto> roleList) {
		Set<Date> dateSet = new TreeSet<>();
		for (UtsRoleDto role : roleList) {
			List<UtsRole> roles = roleService.selectByName(role.getRoleValue());
			for (UtsRole r : roles) {
				Date refreshTime = r.getRefreshTime();
				if (!ObjectUtil.isEmpty(refreshTime)) {
					dateSet.add(refreshTime);
				}
			}
		}
		return dateSet;
	}

	private String getUsername() {
		while (true) {
			String name = RandomUtil.randomNumbers(8);
			Boolean isUsername = selectUsernameIsTrue(name);
			Boolean isNickname = selectNicknameIsTrue(name);
			if (!isUsername && !isNickname) {
				return name;
			}
		}
	}
}
