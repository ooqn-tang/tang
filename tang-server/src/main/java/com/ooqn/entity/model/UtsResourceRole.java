package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Schema(description = "资源角色关联")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"resourceId","roleId"})})
public class UtsResourceRole {

	@Id
    @Column(length = 32)
	private String resourceRoleId;

	@Schema(description = "资源ID")
    @Column(length = 32)
	private String resourceId;

	@Schema(description = "角色ID")
    @Column(length = 32)
	private String roleId;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新事件")
	private Date updateTime;

}
