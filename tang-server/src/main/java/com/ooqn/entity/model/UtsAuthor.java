package com.ooqn.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UtsAuthor {

	@Id
	private String authorId;

	private String username;

	private String nickname;

	private String password;

	private String mail;

	private String signature;

	private Date updateTime;

	private Date refreshTime;
}
