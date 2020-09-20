package net.ttcxy.tang.entity.dto;

import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 * @author huanglei
 */
public class GroupDto implements GrantedAuthority {

    static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
