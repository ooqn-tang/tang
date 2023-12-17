package com.ooqn.entity.model;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicUpdate
@Schema(description = "通用返回对象")
public class DtsArticle {

	@Id
	@Column(length = 32)
	private String articleId;

	@Schema(description = "标题")
	private String title;

	@Column(updatable = false, length = 32)
	@Schema(description = "作者ID")
	@JsonIgnore
	private String authorId;

	@Schema(description = "分类ID")
	@Column(length = 32)
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

	@Schema(description = "正文")
	@Column(length = 32)
	private String textContextId;

	@Schema(description = "markdown")
	@Column(length = 32)
	private String markdownContextId;

}
