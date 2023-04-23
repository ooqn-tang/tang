package com.ooqn.entity.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "系统代码")
public class StsCode {

	@Id
	private Integer codeId;

	@Schema(description = "代码名称")
	private String name;

	@Schema(description = "代码值")
	private String value;
}
