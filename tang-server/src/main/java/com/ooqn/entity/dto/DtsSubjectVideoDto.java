package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.DtsVideo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsSubjectVideoDto extends DtsSubjectDto {

	private List<DtsVideo> videoList;
	
}
