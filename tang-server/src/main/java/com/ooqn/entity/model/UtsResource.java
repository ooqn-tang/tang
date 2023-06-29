package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "资源")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "path", "type" }) })
public class UtsResource {

	@Id
	private String resourceId;

	@Schema(description = "资源路径")
	private String path;

	@Schema(description = "资源名称")
	private String name;

	@Schema(description = "资源类型")
	private String type;

	@Schema(description = "资源状态")
	/**
	 * 1:正常 4:删除
	 */
	private Integer state;
	
	@Schema(description = "创建时间")
	private Date createTime;
	
}
