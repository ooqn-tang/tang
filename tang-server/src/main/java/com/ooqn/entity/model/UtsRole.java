package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "角色")
public class UtsRole {

	@Id
    @Column(length = 32)
	private String roleId;

	@Schema(description = "角色名称")
	@Column(unique=true)
	private String roleName;

	@Schema(description = "角色值")
	@Column(unique=true)
	private String roleValue;

	@Schema(description = "创建人ID")
	@JsonIgnore
    @Column(length = 32)
	private String createAuthorId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新人ID")
    @Column(length = 32)
	private String updateAuthorId;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "刷新时间")
	private Date refreshTime;

}
