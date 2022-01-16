package net.ttcxy.tang.portal.entity.dto;

import net.ttcxy.tang.portal.entity.model.UtsRole;

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
