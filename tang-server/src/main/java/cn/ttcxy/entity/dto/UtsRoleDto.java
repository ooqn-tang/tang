package cn.ttcxy.entity.dto;

import java.util.Date;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 */
@Data
public class UtsRoleDto implements GrantedAuthority {

	private String roleId;

	private String roleName;

	private String roleValue;

	private Date createTime;

	private Date updateTime;

	private Date refreshTime;

	public UtsRoleDto() {
	}

	public UtsRoleDto(String roleId, String roleName, String roleValue, Date createTime, Date updateTime, Date refreshTime) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleValue = roleValue;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.refreshTime = refreshTime;
	}

	@Override
	public String getAuthority() {
		return roleValue;
	}
}
