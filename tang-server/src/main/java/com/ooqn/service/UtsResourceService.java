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
		return resourceRepository.loadResourceUrlByRoleValue(roleValue);
	}

	public List<UtsResource> select(String queryData) {
		return resourceRepository.findByNameLikeAndPathLikeOrderByPath("%" + queryData + "%", "%" + queryData + "%");
	}

	public void insert(UtsResource resource) {
		UtsResource res= resourceRepository.findByPathAndType(resource.getPath(), resource.getType());
		if(res == null) {
			resourceRepository.save(resource);
		}
	}

	public void delete(String resourceId) {
		resourceRepository.deleteById(resourceId);
	}

	public UtsResource selectById(String resourceId) {
		return resourceRepository.findById(resourceId).orElseThrow();
	}

	public UtsResource update(UtsResource resource) {
		return resourceRepository.saveAndFlush(resource);
	}

	public List<String> selectByRoleId(String roleId) {
		return null;//resourceRepository.findByRoleId(roleId);
	}

	
	public void urls() {
		
	}
}
