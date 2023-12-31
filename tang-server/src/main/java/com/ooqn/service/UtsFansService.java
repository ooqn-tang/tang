package com.ooqn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ooqn.core.control.ResponseCode;
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsFans;
import com.ooqn.repository.UtsFansRepository;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;

/**
 * 粉丝相关服务
 */
@Service
public class UtsFansService {

	@Autowired
	private UtsFansRepository fansRepository;

	@Autowired
	private UtsAuthorService authorService;

	public Page<UtsAuthor> selectFansList(String authorId, Pageable pageable) {
		return fansRepository.findFansList(authorId, pageable);
	}

	public UtsFans insertFans(String fansName, String authorId) {
		UtsAuthor author = authorService.selectAuthorByName(fansName);
		if (author == null) {
			throw new ApiException(ResponseCode.VALIDATE_FAILED);
		}

		UtsFans fans = new UtsFans();
		fans.setFansId(IdUtil.objectId());
		fans.setAuthorId(authorId);
		fans.setBeAuthorId(author.getAuthorId());
		fans.setCreateTime(DateTime.now());
		
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
		return fansRepository.countByAuthorIdAndBeAuthorId(authorId, beAuthorId);
	}
}
