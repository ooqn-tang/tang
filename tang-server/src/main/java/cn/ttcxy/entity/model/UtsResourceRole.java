package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UtsResourceRole {

	@Id
	private String resourceRoleId;

	private String resourceId;

	private String roleId;

	private Date createTime;

}
