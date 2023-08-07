package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsCategory;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.UtsAuthor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Article模型类
 */
@Getter
@Setter
@Schema(description = "通用返回对象")
public class DtsArticleDto extends DtsArticle {
	
	public DtsArticleDto(DtsArticle article) {
		BeanUtils.copyProperties(article, this);
	}

	@Schema(description="作者")
	private UtsAuthor author;

	@Schema(description="专题")
	private DtsSubject subject;

	@Schema(description = "分类")
	private DtsCategory category;

	@Schema(description = "正文")
	private String text;

	@Schema(description = "markdown")
	private String markdown;
	
}
