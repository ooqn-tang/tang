package cn.ttcxy.entity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StsCode {

	@Id
	private Integer codeId;

	private String codeName;

	private String codeRemark;
}
