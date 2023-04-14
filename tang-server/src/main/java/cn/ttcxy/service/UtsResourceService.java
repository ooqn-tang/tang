package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.repository.UtsResourceRepository;

@Service
public class UtsResourceService {

	@Autowired
	private UtsResourceRepository resourceRepository;

	public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
		return resourceRepository.loadResourceUrlByRoleValue(roleValue);
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
		return resourceRepository.selectByRoleId(roleId);
	}

	
	public void urls() {
		
	}
}
