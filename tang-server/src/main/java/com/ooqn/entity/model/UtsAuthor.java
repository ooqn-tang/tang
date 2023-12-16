package com.ooqn.entity.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "作者")
public class UtsAuthor {

	public UtsAuthor(){}

	
	public UtsAuthor(String username, String nickname) {
		this.username = username;
		this.nickname = nickname;
	}

	@Id
    @Column(length = 32)
	private String authorId;

	@Schema(description = "用户名")
	@Column(unique=true)
	private String username;

	@Schema(description = "昵称")
	@Column(unique=true)
	private String nickname;

	@Schema(description = "密码")
	@JsonIgnore
	private String password;

	@Schema(description = "邮箱")
	@Column(unique=true)
	private String mail;

	@Schema(description = "签名")
	private String signature;

	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(description = "刷新时间")
	private Date refreshTime;
}
