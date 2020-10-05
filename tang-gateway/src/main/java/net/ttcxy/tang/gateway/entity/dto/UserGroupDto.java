package net.ttcxy.tang.gateway.entity.dto;

/**
 * @author huanglei
 */
public class UserGroupDto {

    static final long serialVersionUID = 1L;

    private String userId;

    private String roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
