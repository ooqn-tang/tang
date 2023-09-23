package com.ooqn.service;

import com.ooqn.entity.model.DtsCollect;
import com.ooqn.repository.DtsCollectRepository;

import cn.hutool.core.util.IdUtil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtsCollectService {

	@Autowired
	private DtsCollectRepository collectRepository;

	public long select(String dataId, String authorId) {
		return collectRepository.countByDataIdAndAuthorId(dataId, authorId);
	}

	public Page<DtsCollect> selectCollect(String authorId, Pageable pageable) {
		return collectRepository.findByAuthorId(authorId, pageable);
	}

	public DtsCollect insert(DtsCollect collect, String authorId) {
		collect.setCollectId(IdUtil.objectId());
		collect.setAuthorId(authorId);
		collect.setCreateTime(new Date());
		return collectRepository.save(collect);
	}

	public void unCollect(String authorId, String dataId) {
		//collectRepository.deleteByDataIdAndAuthorId(dataId, authorId);
	}
}
