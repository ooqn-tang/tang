package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据收藏")
public class DtsCollect {

	@Id
	@Column(length = 32)
	private String collectId;

	@Schema(description = "作者ID")
	@JsonIgnore
	@Column(length = 32)
	private String authorId;

	@Schema(description = "标题")
	private String title;

	@Schema(description = "摘要")
	private String synopsis;

	@Schema(description = "收藏的RUL")
	private String url;

	@Schema(description = "创建时间")
	private Date createTime;
}
