package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.DtsArticle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsSubjectArticleDto extends DtsSubjectDto {

	private List<DtsArticle> articleList;
	
}
