package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "短文")
public class DtsEssay {

	@Id
	private String essayId;

	@Schema(description = "作者id")
	@JsonIgnore
	private String authorId;

	@Schema(description = "文本")
	private String text;

	@Schema(description = "url")
	private String url;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "类型")
	private String type;
	
}
