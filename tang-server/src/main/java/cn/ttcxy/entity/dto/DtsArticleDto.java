package cn.ttcxy.entity.dto;

import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.entity.model.UtsAuthor;
import lombok.Getter;
import lombok.Setter;

/**
 * Article模型类
 */
@Getter
@Setter
public class DtsArticleDto {

	/**
	 * 浏览器访问量
	 */
	private Integer pageViewCount;

	/**
	 * 点赞量
	 */
	private Integer likeCount;

	/**
	 * 收藏量
	 */
	private Integer collectCount;

	private DtsArticle article;

	private UtsAuthor author;

	private DtsArticleSubject subject;
	
}
