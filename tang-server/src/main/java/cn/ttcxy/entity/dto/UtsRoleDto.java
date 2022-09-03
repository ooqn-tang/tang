package cn.ttcxy.entity.dto;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

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
    @Override
    public String getAuthority() {
        return roleValue;
    }

}