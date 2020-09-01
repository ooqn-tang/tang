package net.ttcxy.tang.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 * @author huanglei
 */
public class Role implements GrantedAuthority {

    private String id;

    private String name;

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
