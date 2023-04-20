package com.ooqn.entity.dto;

import com.ooqn.entity.model.DtsMessage;
import com.ooqn.entity.model.UtsAuthor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsMessageDto {

	private DtsMessage message;

	private UtsAuthor author;

	
}
