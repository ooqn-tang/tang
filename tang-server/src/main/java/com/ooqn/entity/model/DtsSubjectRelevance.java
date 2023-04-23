package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DtsSubjectRelevance {

	@Id
	@Schema(description = "专辑关联ID")
	private String subjectRelevanceId;

	@Schema(description = "数据id")
	private String dataId;

	@Schema(description = "专辑ID")
	private String subjectId;

	@Schema(description = "排序")
	private Integer orderNum;
	
	@Schema(description = "创建人id")
	private String createAuthorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新人id")
	private String updateAuthorId;

	@Schema(description = "更新时间")
	private Date updateTime;




}
