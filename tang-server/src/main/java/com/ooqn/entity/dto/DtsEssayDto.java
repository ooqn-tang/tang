package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.DtsEssay;
import com.ooqn.entity.model.UtsAuthor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsEssayDto extends DtsEssay {

	public DtsEssayDto(DtsEssay essay){
		BeanUtils.copyProperties(essay, this);
	}

	private UtsAuthor author;
	
}
