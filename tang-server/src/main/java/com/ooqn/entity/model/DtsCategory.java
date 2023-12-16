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
	@Column(length = 32)
	private String categoryId;

	// 1:文章分类 2:专题分类 3:标签分类
	@Schema(description = "分类类型")
	private String type;

	@Schema(description = "分类名称")
	@Column(unique=true)
	private String name;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "OrderNum")
	private Integer orderNum;

	// 1:正常 2:未激活
	@Schema(description = "是否激活")
	private Integer active;

}
