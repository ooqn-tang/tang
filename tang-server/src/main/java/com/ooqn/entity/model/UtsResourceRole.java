package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "资源角色关联")
public class UtsResourceRole {

	@Id
	private String resourceRoleId;

	@Schema(description = "资源ID")
	private String resourceId;

	@Schema(description = "角色ID")
	private String roleId;

	@Schema(description = "创建时间")
	private Date createTime;

}
