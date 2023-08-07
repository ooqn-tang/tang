package com.ooqn.entity.dto;

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
public class DtsArticleDto {

	@Schema(description = "浏览器访问量")
	private Integer pageViewCount;

	@Schema(description="点赞量")
	private Integer likeCount;

	@Schema(description="收藏量")
	private Integer collectCount;

	@Schema(description ="文章")
	private DtsArticle article;

	@Schema(description="作者")
	private UtsAuthor author;

	@Schema(description="专题")
	private DtsSubject subject;

	@Schema(description = "分类")
	private DtsCategory category;
	
}
