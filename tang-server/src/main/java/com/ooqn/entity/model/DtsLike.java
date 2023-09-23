package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据点赞")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"dataId","dataType","authorId"})})
public class DtsLike {

	@Id
	private String likeId;

	@Schema(description = "数据ID")
	private String dataId;

	@Schema(description = "数据类型")
	private String dataType;

	@Schema(description = "作者ID")
	@JsonIgnore
	private String authorId;

	@Schema(description = "创建时间")
	private Date createTime;
}
