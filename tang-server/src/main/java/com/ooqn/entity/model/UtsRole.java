package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "角色")
public class UtsRole {

	@Id
	private String roleId;

	@Schema(description = "角色名称")
	private String roleName;

	@Schema(description = "角色值")
	private String roleValue;

	@Schema(description = "创建人ID")
	private String createAuthorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新人ID")
	private String updateAuthorId;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "刷新时间")
	private Date refreshTime;

}
