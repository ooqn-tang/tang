package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.dao.dsl.DtsEssayDsl;
import cn.ttcxy.dao.repository.DtsEssayRepository;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtsEssayService {

	@Autowired
	private DtsEssayRepository essayRepository;

	@Autowired
	private DtsEssayDsl essayDsl;

	public DtsEssay insert(DtsEssay dynamic) {
		dynamic.setEssayId(IdUtil.objectId());
		dynamic.setCreateTime(DateUtil.date());
		return essayRepository.save(dynamic);
	}

	public void delete(String authorId) {
		essayRepository.deleteById(authorId);
	}

	public Page<DtsEssayDto> select(Pageable pageable) {
		return essayDsl.select(pageable);
	}
}
