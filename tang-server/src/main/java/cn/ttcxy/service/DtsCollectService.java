package cn.ttcxy.service;

import cn.ttcxy.dao.dsl.DtsCollectDsl;
import cn.ttcxy.dao.repository.DtsCollectRepository;
import cn.ttcxy.entity.model.DtsCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtsCollectService {

	@Autowired
	private DtsCollectRepository collectRepository;

	@Autowired
	private DtsCollectDsl collectDsl;

	public long select(String authorId, String dataId) {
		return collectRepository.countByDataIdAndAuthorId(dataId, authorId);
	}

	public Page<DtsCollect> selectCollect(String authorId, Pageable pageable) {
		return collectDsl.selectCollect(authorId, pageable);
	}

	public DtsCollect insert(DtsCollect collect) {
		return collectRepository.save(collect);
	}

	public int unCollect(String authorId, String dataId) {
		return collectRepository.deleteByDataIdAndAuthorId(dataId, authorId);
	}
}
