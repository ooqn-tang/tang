package com.ooqn.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.ooqn.entity.model.DtsMessage;
import com.ooqn.repository.DtsMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsMessageService {

	@Autowired
	private DtsMessageRepository messageRepository;

	public void insertMessage(String dataId, String title, String text, String url, String authorId,
			String recipientAuthorId, String type) {
		DtsMessage message = new DtsMessage();
		message.setTitle(title);
		message.setText(text);
		message.setMessageId(IdUtil.objectId());
		message.setCreateTime(DateUtil.date());
		message.setUrl(url);
		message.setAuthorId(authorId);
		message.setRecipientAuthorId(recipientAuthorId);
		messageRepository.save(message);
	}
}
