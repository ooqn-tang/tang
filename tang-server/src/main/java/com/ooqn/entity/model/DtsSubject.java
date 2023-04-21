package com.ooqn.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsSubject {

	@Id
	private String subjectId;

	private String subjectName;

	private String authorId;

	private Integer orderNum;

	private Date createDate;

	private Date updateDate;

	private String synopsis;
}
