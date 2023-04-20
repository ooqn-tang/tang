package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsArticleSubject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsArticleSubjectDto {

	private DtsArticleSubject subject;

	private List<DtsArticle> articleList;
	
}
