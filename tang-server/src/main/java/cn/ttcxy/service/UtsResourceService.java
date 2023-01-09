package cn.ttcxy.service;

import cn.ttcxy.dao.dsl.UtsResourceDsl;
import cn.ttcxy.dao.repository.UtsResourceRepository;
import cn.ttcxy.entity.model.UtsResource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtsResourceService {

	@Autowired
	private UtsResourceDsl resourceDls;

	@Autowired
	private UtsResourceRepository resourceRepository;

	public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
		return resourceDls.loadResourceUrlByRoleValue(roleValue);
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
		return resourceDls.selectByRoleId(roleId);
	}

	
	public void urls() {
		
	}
}
