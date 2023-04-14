package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UtsRole {

	@Id
	private String roleId;

	private String roleName;

	private String roleValue;

	private Date createTime;

	private Date updateTime;

	private Date refreshTime;
}
