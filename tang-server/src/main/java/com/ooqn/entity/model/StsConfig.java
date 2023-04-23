package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "系统配置")
public class StsConfig {

	@Id
	private String configId;

	@Schema(description = "配置名称")
	private String name;

	@Schema(description = "配置值")
	private String data;

	@Schema(description = "创建时间")
	private Date createTime;
}
