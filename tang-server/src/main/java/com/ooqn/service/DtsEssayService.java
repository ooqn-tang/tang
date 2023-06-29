package com.ooqn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ooqn.entity.dto.DtsEssayDto;
import com.ooqn.entity.model.DtsEssay;
import com.ooqn.repository.DtsEssayRepository;
import com.ooqn.repository.UtsAuthorRepository;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

@Service
public class DtsEssayService {

	
	@Autowired
	private DtsEssayRepository essayRepository;

	@Autowired
	private UtsAuthorRepository authorRepository;

	public DtsEssay insert(DtsEssay dynamic) {
		dynamic.setEssayId(IdUtil.objectId());
		dynamic.setCreateTime(DateUtil.date());
		return essayRepository.save(dynamic);
	}

	public void delete(String authorId) {
		essayRepository.deleteById(authorId);
	}

	public Page<DtsEssayDto> findAllInfo(Pageable pageable) {
		 return essayRepository.findAll(pageable).map(essay -> {
			DtsEssayDto essayDto = new DtsEssayDto();
			essayDto.setEssay(essay);
			essayDto.setAuthor(authorRepository.findById(essay.getAuthorId()).orElseThrow());
			return essayDto;
		 });
	}
}
