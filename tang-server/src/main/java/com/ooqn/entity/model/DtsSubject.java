package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据主题")
public class DtsSubject {

	@Id
	private String subjectId;

	private String subjectName;

	@JsonIgnore
	private String authorId;

	@Schema(description = "排序")
	private Integer orderNum;

	private Date createTime;

	private Date updateDate;

	private String synopsis;
}
