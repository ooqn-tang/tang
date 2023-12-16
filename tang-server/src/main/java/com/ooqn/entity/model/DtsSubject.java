package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据主题")
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"subjectName","authorId"}))
public class DtsSubject {

	@Id
	@Column(length = 32)
	private String subjectId;

	private String subjectName;

	@JsonIgnore
	@Column(length = 32)
	private String authorId;

	@Schema(description = "排序")
	private Integer orderNum;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;

	private String synopsis;
}
