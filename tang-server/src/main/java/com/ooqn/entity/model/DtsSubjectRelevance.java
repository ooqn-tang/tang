package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "dataId", "subjectId" })})
public class DtsSubjectRelevance {

	@Id
	@Schema(description = "专辑关联ID")
	@Column(length = 32)
	private String subjectRelevanceId;

	@Schema(description = "数据id")
	@Column(length = 32)
	private String dataId;

	@Schema(description = "专辑ID")
	@Column(length = 32)
	private String subjectId;

	@Schema(description = "排序")
	private Integer orderNum;

	@Schema(description = "创建人id")
	@JsonIgnore
	@Column(length = 32)
	private String authorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新人id")
	@Column(length = 32)
	private String updateAuthorId;

	@Schema(description = "更新时间")
	private Date updateTime;

}
