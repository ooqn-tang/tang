package cn.ttcxy.entity.dto;

import cn.ttcxy.entity.model.UtsRole;
import java.util.Set;

public class UtsRoleResourceDto {

	private String path;
	
	Set<UtsRole> roleSet;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<UtsRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<UtsRole> roleSet) {
		this.roleSet = roleSet;
	}
}
