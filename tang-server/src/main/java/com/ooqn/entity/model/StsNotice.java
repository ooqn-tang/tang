package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Schema(description = "系统公告")
public class StsNotice {

	@Id
	private String noticeId;

	@Schema(description = "公告标题")
	private String title;

	@Schema(description = "跳转连接")
	private String url;

	@Schema(description = "公告描述")
	private String description;

	@Schema(description = "公告类型")
	private String type;

	@Schema(description = "公告状态")
	private String status;
	
	@Schema(description = "排序")
	private Integer orderNum;

	@Schema(description = "创建人")
	@JsonIgnore
	private String authorId;

	@Schema(description = "创建时间")
	private Date createTime;

}
