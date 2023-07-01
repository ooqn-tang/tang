package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "作者角色")
public class UtsAuthorRole {

	@Id
	private String authorRoleId;

	@Schema(description = "作者ID")
	@JsonIgnore
	private String authorId;

	@Schema(description = "角色ID")
	private String roleId;

	@Schema(description = "创建时间")
	private Date createTime;
}
