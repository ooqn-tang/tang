package com.ooqn.service;

import java.util.List;

import com.ooqn.entity.dto.DtsEssayDto;
import com.ooqn.entity.model.DtsEssay;
import com.ooqn.repository.DtsEssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

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

	public List<DtsEssayDto> findAllInfo() {
		return null;//essayRepository.findAllInfo();
	}
}
