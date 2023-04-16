package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.entity.model.DtsClass;
import cn.ttcxy.repository.DtsClassRepository;

@Service
public class DtsClassService {

	@Autowired
	private DtsClassRepository classRepository;

	public List<DtsClass> selectClass(String type) {
		return classRepository.findByType(type);
	}
}
