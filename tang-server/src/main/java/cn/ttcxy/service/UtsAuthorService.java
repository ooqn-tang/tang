package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.ttcxy.dao.dsl.UtsAuthorDsl;
import cn.ttcxy.dao.repository.UtsAuthorRepository;
import cn.ttcxy.dao.repository.UtsAuthorRoleRepository;
import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsAuthorRole;
import cn.ttcxy.entity.model.UtsRole;
import cn.ttcxy.entity.param.UtsRoleParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.transaction.Transactional;
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
	private UtsAuthorRepository utsAuthorRepository;

	@Autowired
	private UtsAuthorDsl authorDsl;

	@Autowired
	private UtsAuthorRoleRepository authorRoleRepository;

	@Autowired
	private UtsRoleService roleService;

	private static final Map<String, Date> usernameTime = new HashMap<>();

	public UtsAuthor selectAuthorByName(String username) {
		return utsAuthorRepository.findByUsername(username);
	}

	public UtsAuthor selectAuthorByMail(String mail) {
		return utsAuthorRepository.findByMail(mail);
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
		return utsAuthorRepository.save(author);
	}

	public long update(UtsAuthor author) {
		return authorDsl.updata(author);
	}

	public Boolean selectUsernameIsTrue(String username) {
		return utsAuthorRepository.countByUsername(username) > 0;
	}

	public Boolean selectNicknameIsTrue(String nickname) {
		return utsAuthorRepository.countByNickname(nickname) > 0;
	}

	public Boolean selectMailIsTrue(String mail) {
		return utsAuthorRepository.countByMail(mail) > 0;
	}

	public Page<UtsAuthor> selectAuthor(Pageable pageable) {
		return utsAuthorRepository.findAll(pageable);
	}

	public List<UtsAuthor> select(String queryData) {
		return utsAuthorRepository.findByMailLikeAndUsernameLikeAndNicknameLike(
				"%" + queryData + "%", "%" + queryData + "%", "%" + queryData + "%");
	}

	public void delete(String authorId) {
		authorDsl.updateStateDelete(authorId);
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
