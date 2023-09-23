package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.DtsMessage;
import com.ooqn.entity.model.UtsAuthor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsMessageDto extends DtsMessage {

	public DtsMessageDto(DtsMessage message){
		BeanUtils.copyProperties(message, this);
	}

	private UtsAuthor author;

	
}
