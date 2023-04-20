package com.ooqn.service;

import java.util.List;

import com.ooqn.entity.model.DtsClass;
import com.ooqn.repository.DtsClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsClassService {

	@Autowired
	private DtsClassRepository classRepository;

	public List<DtsClass> selectClass(String type) {
		return classRepository.findByType(type);
	}
}
