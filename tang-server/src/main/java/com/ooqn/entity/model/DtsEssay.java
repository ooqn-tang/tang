package com.ooqn.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsEssay {

	@Id
	private String essayId;

	private String authorId;

	private String text;

	private String url;

	private Date createTime;

	private String coverUrl;

	private String type;
}
