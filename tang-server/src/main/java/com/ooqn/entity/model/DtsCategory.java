package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据分类")
public class DtsCategory {

	@Id
	private String categoryId;

	@Schema(description = "父分类ID")
	private String parentId;

	// 1:文章分类 2:专题分类 3:标签分类
	@Schema(description = "分类类型")
	private String type;

	@Schema(description = "分类名称")
	private String name;

	@Schema(description = "值")
	@Column(columnDefinition = "VAL varchar(100) COMMENT '值'")
	private String value;

	@Schema(description = "创建作者ID")
	private String createAuthorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "OrderNum")
	private Integer orderNum;

}
