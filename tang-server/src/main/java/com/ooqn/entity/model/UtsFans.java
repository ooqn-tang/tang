package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "用户粉丝")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "beAuthorId", "authorId" }) })
public class UtsFans {

	@Id
	private String fansId;

	@Schema(description = "被关注者ID")
	private String beAuthorId;

	@Schema(description = "关注者ID")
	private String authorId;

	@Schema(description = "创建时间")
	private Date createTime;
}
