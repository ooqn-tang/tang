package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsFans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtsFansDto extends UtsFans {
	
	public UtsFansDto(UtsFans fans){
		BeanUtils.copyProperties(fans, this);
	}

	UtsAuthor author;
	
}
