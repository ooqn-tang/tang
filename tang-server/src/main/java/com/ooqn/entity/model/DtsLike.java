package com.ooqn.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsLike {

	@Id
	private String likeId;

	private String dataId;

	private String dataType;

	private String authorId;

	private Date createTime;
}
