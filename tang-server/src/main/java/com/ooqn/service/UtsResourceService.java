package com.ooqn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.model.UtsResource;
import com.ooqn.repository.UtsResourceRepository;

import cn.hutool.core.util.IdUtil;

@Service
public class UtsResourceService {

	@Autowired
	private UtsResourceRepository resourceRepository;

	
	public List<UtsResource> select(String queryData) {
		return resourceRepository.findByNameLikeAndPathLikeOrderByPath("%" + queryData + "%", "%" + queryData + "%");
	}

	public UtsResource select(String path, String type){
		return resourceRepository.findByPathAndType(path, type);
	}

	public UtsResource insert(UtsResource resource) {
		UtsResource res = resourceRepository.findByPathAndType(resource.getPath(), resource.getType());
		if(res == null) {
			resource.setResourceId(IdUtil.objectId());
			resource.setCreateTime(new Date());
			return resourceRepository.save(resource);
		}else{
			throw new ApiException("内容以及存在");
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

	public List<UtsResource> selectByRoleId(String roleId) {
		return resourceRepository.findByRoleId(roleId);
	}
	
	public void urls() {
		
	}
}
