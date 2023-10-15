package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "消息")
public class DtsMessage {

	@Id
	private String messageId;

	@Schema(description = "作者ID")
	@JsonIgnore
	private String authorId;

	@Schema(description = "接收者ID")
	private String recipientAuthorId;
	
	@Schema(description = "文本")
	private String text;
	
	@Schema(description = "消息点击打开连接")
	private String url;
	
	@Schema(description = "标题")
	private String title;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;
}
