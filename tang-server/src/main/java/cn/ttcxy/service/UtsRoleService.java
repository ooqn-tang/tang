package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import cn.ttcxy.dao.dsl.UtsRoleDsl;
import cn.ttcxy.dao.repository.UtsResourceRoleRepository;
import cn.ttcxy.dao.repository.UtsRoleRepository;
import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.model.UtsResourceRole;
import cn.ttcxy.entity.model.UtsRole;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtsRoleService {

	@Autowired
	private UtsRoleDsl roleDls;

	@Autowired
	private UtsRoleRepository roleRepository;

	@Autowired
	private UtsResourceRoleRepository resourceRoleRepository;

	public List<UtsRoleDto> roleList(String authorId) {
		return roleDls.selectRoleListByAuthorId(authorId);
	}

	public UtsRole selectById(String roleId) {
		return roleRepository.findById(roleId).orElseThrow();
	}

	public void delete(String roleId) {
		roleRepository.deleteById(roleId);
	}

	public UtsRole update(UtsRole role) {
		return roleRepository.save(role);
	}

	public UtsRole insert(UtsRole role) {
		return roleRepository.save(role);
	}

	public Iterable<UtsRole> select() {
		return roleRepository.findAll();
	}

	public void insertResource(String roleId, List<UtsResource> resourceList) {
		resourceRoleRepository.deleteByRoleId(roleId);
		for (UtsResource utsResource : resourceList) {
			UtsResourceRole resourceRole = new UtsResourceRole();
			resourceRole.setRoleId(roleId);
			resourceRole.setResourceId(utsResource.getResourceId());
			resourceRole.setCreateTime(new Date());
			resourceRole.setResourceRoleId(IdUtil.objectId());
			resourceRoleRepository.save(resourceRole);
		}
	}

	public List<String> selectRoleIdList(String authorId) {
		return roleDls.selectRoleIdList(authorId);
	}

	public List<UtsRole> selectByName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
