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

	public String getResourceRoleId() {
		return resourceRoleId;
	}

	public void setResourceRoleId(String resourceRoleId) {
		this.resourceRoleId = resourceRoleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
