package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据分类")
public class DtsClass {

	@Id
	private String classId;

	@Schema(description = "父分类ID")
	private String parentId;

	@Schema(description = "分类类型")
	private String type;

	@Schema(description = "分类名称")
	private String name;

	@Schema(description = "创建作者ID")
	private String createAuthorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新作者ID")
	private String updateAuthorId;

	@Schema(description = "更新时间")
	private Date updateTime;

}
