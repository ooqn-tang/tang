package com.ooqn.entity.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.UtsAuthor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsSubjectDto extends DtsSubject {

	public DtsSubjectDto(DtsSubject subject){
		BeanUtils.copyProperties(subject, this);
	}

    private UtsAuthor author;

	private List<?> dataArray;
	
}
