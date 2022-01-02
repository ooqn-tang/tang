package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsAuthorRole implements Serializable {
    private String authorRoleId;

    private String authorId;

    private String roleId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getAuthorRoleId() {
        return authorRoleId;
    }

    public void setAuthorRoleId(String authorRoleId) {
        this.authorRoleId = authorRoleId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorRoleId=").append(authorRoleId);
        sb.append(", authorId=").append(authorId);
        sb.append(", roleId=").append(roleId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}