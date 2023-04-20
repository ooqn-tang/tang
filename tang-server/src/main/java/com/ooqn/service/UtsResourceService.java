package com.ooqn.service;

import java.util.List;

import com.ooqn.entity.model.UtsResource;
import com.ooqn.repository.UtsResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtsResourceService {

	@Autowired
	private UtsResourceRepository resourceRepository;

	public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
		return null;//resourceRepository.loadResourceUrlByRoleValue(roleValue);
	}

	public List<UtsResource> select(String queryData) {
		return resourceRepository.findByNameLikeAndPathLike("%" + queryData + "%",
				"%" + queryData + "%");
	}

	public UtsResource insert(UtsResource resource) {
		return resourceRepository.save(resource);
	}

	public void delete(String resourceId) {
		resourceRepository.deleteById(resourceId);
	}

	public UtsResource selectById(String resourceId) {
		return resourceRepository.findById(resourceId).orElseThrow();
	}

	public UtsResource update(UtsResource resource) {
		return resourceRepository.save(resource);
	}

	public List<String> selectByRoleId(String roleId) {
		return null;//resourceRepository.findByRoleId(roleId);
	}

	
	public void urls() {
		
	}
}
