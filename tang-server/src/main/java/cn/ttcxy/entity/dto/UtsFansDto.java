package cn.ttcxy.entity.dto;

import java.util.Date;

public class UtsFansDto {

	private String fansId;

	private String authorId;

	private String beAuthorId;

	private String nickname;

	private String username;

	private Date createDate;

	public String getFansId() {
		return fansId;
	}

	public void setFansId(String fansId) {
		this.fansId = fansId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getBeAuthorId() {
		return beAuthorId;
	}

	public void setBeAuthorId(String beAuthorId) {
		this.beAuthorId = beAuthorId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
