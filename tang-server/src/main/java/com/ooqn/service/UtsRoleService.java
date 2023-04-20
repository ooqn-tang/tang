package com.ooqn.service;

import java.util.Date;
import java.util.List;

import com.ooqn.entity.dto.UtsRoleDto;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.model.UtsResourceRole;
import com.ooqn.entity.model.UtsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.IdUtil;
import com.ooqn.repository.UtsResourceRoleRepository;
import com.ooqn.repository.UtsRoleRepository;

@Service
public class UtsRoleService {

	@Autowired
	private UtsRoleRepository roleRepository;

	@Autowired
	private UtsResourceRoleRepository resourceRoleRepository;

	public List<UtsRoleDto> roleList(String authorId) {
		return null;//roleRepository.findRoleListByAuthorId(authorId);
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
		return null;//roleRepository.findRoleIdList(authorId);
	}

	public List<UtsRole> selectByName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
