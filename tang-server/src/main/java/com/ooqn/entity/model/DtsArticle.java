package com.ooqn.entity.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Data
@DynamicUpdate
@Schema(description = "通用返回对象")
public class DtsArticle {

	@Id
	private String articleId;

	@Schema(description = "标题")
	private String title;

	@Column(updatable = false)
	@Schema(description = "作者ID")
	private String authorId;

	@Schema(description = "分类ID")
	private String categoryId;

	@Column(updatable = false)
	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "状态")
	private Integer state;

	@Schema(description = "概要")
	private String synopsis;

	@Lob
	@Schema(description = "正文")
	private String text;

	@Lob
	@Schema(description = "markdown")
	private String markdown;
}
