package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.repository.DtsCollectRepository;

@Service
public class DtsCollectService {

	@Autowired
	private DtsCollectRepository collectRepository;

	public long select(String authorId, String dataId) {
		return collectRepository.countByDataIdAndAuthorId(dataId, authorId);
	}

	public Page<DtsCollect> selectCollect(String authorId, Pageable pageable) {
		return collectRepository.selectCollect(authorId, pageable);
	}

	public DtsCollect insert(DtsCollect collect) {
		return collectRepository.save(collect);
	}

	public int unCollect(String authorId, String dataId) {
		return collectRepository.deleteByDataIdAndAuthorId(dataId, authorId);
	}
}
