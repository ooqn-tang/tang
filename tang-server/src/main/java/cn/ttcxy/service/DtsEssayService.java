package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.repository.DtsEssayRepository;

@Service
public class DtsEssayService {

	
	@Autowired
	private DtsEssayRepository essayRepository;

	public DtsEssay insert(DtsEssay dynamic) {
		dynamic.setEssayId(IdUtil.objectId());
		dynamic.setCreateTime(DateUtil.date());
		return essayRepository.save(dynamic);
	}

	public void delete(String authorId) {
		essayRepository.deleteById(authorId);
	}

	public Page<DtsEssayDto> findAllInfo(Pageable pageable) {
		return essayRepository.findAllInfo(pageable);
	}
}
