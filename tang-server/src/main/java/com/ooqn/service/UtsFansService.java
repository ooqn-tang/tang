package com.ooqn.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import com.ooqn.entity.dto.UtsFansDto;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsFans;
import com.ooqn.repository.UtsFansRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 粉丝相关服务
 */
@Service
public class UtsFansService {

	@Autowired
	private UtsFansRepository fansRepository;

	@Autowired
	private UtsAuthorService authorService;

	public Page<UtsFansDto> selectFansList(String authorId, Pageable pageable) {
		return null;//fansRepository.findFansList(authorId, pageable);
	}

	public UtsFans insertFans(UtsFans fans) {
		fans.setCreateDate(DateTime.now());
		fans.setFansId(IdUtil.objectId());
		return fansRepository.save(fans);
	}

	public int deleteFans(String fansName, String authorId) {
		UtsAuthor author = authorService.selectAuthorByName(fansName);
		if (author != null) {
			return fansRepository.deleteByBeAuthorIdAndAuthorId(author.getAuthorId(), authorId);
		}
		return 0;
	}

	public Long isFans(String authorId, String beAuthorId) {
		return null;//fansRepository.isFans(authorId, beAuthorId);
	}
}