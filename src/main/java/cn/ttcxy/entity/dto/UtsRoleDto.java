package cn.ttcxy.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.Objects;

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
