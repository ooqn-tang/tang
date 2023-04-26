package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "用户粉丝")
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
