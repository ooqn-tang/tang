package cn.ttcxy.service;

import cn.ttcxy.dao.repository.DtsLikeRepository;
import cn.ttcxy.entity.model.DtsLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsLikeService {

	@Autowired
	private DtsLikeRepository likeRepository;

	public DtsLike insert(DtsLike praise) {
		return likeRepository.save(praise);
	}

	/**
	 * 返回记录的行数
	 */
	public long select(String authorId, String dataId) {
		return likeRepository.countByAuthorIdAndDataId(authorId, dataId);
	}

	public void delete(String authorId, String dataId) {
		likeRepository.deleteByAuthorIdAndDataId(authorId, dataId);
	}
}
