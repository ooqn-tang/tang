package com.ooqn.service;

import com.ooqn.entity.model.DtsCollect;
import com.ooqn.repository.DtsCollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtsCollectService {

	@Autowired
	private DtsCollectRepository collectRepository;

	public long select(String authorId, String dataId) {
		return collectRepository.countByDataIdAndAuthorId(dataId, authorId);
	}

	public Page<DtsCollect> selectCollect(String authorId, Pageable pageable) {
		return null;//collectRepository.selectCollect(authorId, pageable);
	}

	public DtsCollect insert(DtsCollect collect) {
		return collectRepository.save(collect);
	}

	public void unCollect(String authorId, String dataId) {
		//collectRepository.deleteByDataIdAndAuthorId(dataId, authorId);
	}
}
