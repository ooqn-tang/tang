package com.ooqn.entity.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtsAuthorDto extends UtsAuthor {

	public UtsAuthorDto() {
	}

	public UtsAuthorDto(UtsAuthor author) {
		BeanUtils.copyProperties(author, this);
	}
	
	private List<UtsRole> roleList;

}
