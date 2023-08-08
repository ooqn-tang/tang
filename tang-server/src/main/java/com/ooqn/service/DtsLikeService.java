package com.ooqn.service;

import com.ooqn.entity.model.DtsLike;
import com.ooqn.repository.DtsLikeRepository;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsLikeService {

	@Autowired
	private DtsLikeRepository likeRepository;

	public DtsLike insert(String dataId, String authorId) {
		DtsLike praise = new DtsLike();
		praise.setLikeId(IdUtil.objectId());
		praise.setDataId(dataId);
		praise.setAuthorId(authorId);
		praise.setCreateTime(DateUtil.date());
		return likeRepository.save(praise);
	}
	
	public long select(String dataId, String authorId) {
		return likeRepository.countByAuthorIdAndDataId(authorId, dataId);
	}

	public void delete(String dataId, String authorId) {
		likeRepository.deleteByAuthorIdAndDataId(authorId, dataId);
	}
}
