package com.ooqn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.entity.model.UtsResource;
import com.ooqn.entity.model.UtsResourceRole;
import com.ooqn.entity.model.UtsRole;
import com.ooqn.repository.UtsResourceRoleRepository;
import com.ooqn.repository.UtsRoleRepository;

import cn.hutool.core.util.IdUtil;

@Service
public class UtsRoleService {

	@Autowired
	private UtsRoleRepository roleRepository;

	@Autowired
	private UtsResourceRoleRepository resourceRoleRepository;

	public List<UtsRole> roles(String username) {
		return roleRepository.findRolesByUsername(username);
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
		role.setRoleId(IdUtil.objectId());
		role.setCreateTime(new Date());
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

	public List<UtsRole> selectRolesByAuthorId(String authorId) {
		return roleRepository.findRolesByAuthorId(authorId);
	}

	public List<UtsRole> selectByName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
