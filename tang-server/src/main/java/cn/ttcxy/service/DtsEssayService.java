package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<DtsEssayDto> findAllInfo() {
		return essayRepository.findAllInfo();
	}
}
