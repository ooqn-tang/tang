package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "数据收藏")
public class DtsCollect {

	@Id
	private String collectId;

	@Schema(description = "作者ID")
	private String authorId;

	@Schema(description = "数据ID")
	private String dataId;

	@Schema(description = "数据类型")
	private String dataType;

	@Schema(description = "摘要")
	private String synopsis;

	@Schema(description = "收藏的RUL")
	private String url;

	@Schema(description = "创建时间")
	private Date createTime;
}
