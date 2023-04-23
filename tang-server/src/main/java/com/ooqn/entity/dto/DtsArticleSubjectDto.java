package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.UtsAuthor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsArticleSubjectDto {

	private DtsSubject subject;

	private UtsAuthor author;

	private List<DtsArticle> articleList;
	
}
