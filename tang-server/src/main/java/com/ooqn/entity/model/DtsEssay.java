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
@Schema(description = "短文")
public class DtsEssay {

	@Id
	@Column(length = 32)
	private String essayId;

	@Schema(description = "上级")
	@Column(length = 32)
	private String parentId;

	@Schema(description = "作者id")
	@JsonIgnore
	@Column(length = 32)
	private String authorId;

	@Schema(description = "标签")
	private String tagName;

	@Schema(description = "文本")
	private String text;

	@Schema(description = "创建时间")
	private Date createTime;
	
}
