package com.ooqn.entity.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtsResource {

	@Id
	private String resourceId;

	private String path;

	private String name;

	private String type;

	private Integer state;
	
	private Date createTime;
	
}
