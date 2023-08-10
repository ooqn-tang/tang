package com.ooqn.entity.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "系统代码")
public class StsCode {

	@Id
	private String codeId;

	@Schema(description = "代码名称")
	@Column(unique=true)
	private String codeName;

	@Schema(description = "代码值")
	@Column(unique=true)
	private String codeValue;
}
