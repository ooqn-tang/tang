package com.ooqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.entity.dto.DtsMessageDto;
import com.ooqn.repository.DtsMessageRepository;

/**
 * 用户的动态包括关注的作者，自己的内容等
 */
@Service
public class DtseMssageService {

	@Autowired
	private DtsMessageRepository messageRepository;

	public List<DtsMessageDto> authorMessageList(String authorId) {
		return null;//messageRepository.findAuthorMessage(authorId);
	}
}
