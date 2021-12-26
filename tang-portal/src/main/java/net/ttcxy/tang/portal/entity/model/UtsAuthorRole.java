package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsAuthorRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_author_role.author_role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String authorRoleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_author_role.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_author_role.role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_author_role.create_time
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_author_role.author_role_id
     *
     * @return the value of uts_author_role.author_role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getAuthorRoleId() {
        return authorRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_author_role.author_role_id
     *
     * @param authorRoleId the value for uts_author_role.author_role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setAuthorRoleId(String authorRoleId) {
        this.authorRoleId = authorRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_author_role.author_id
     *
     * @return the value of uts_author_role.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_author_role.author_id
     *
     * @param authorId the value for uts_author_role.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_author_role.role_id
     *
     * @return the value of uts_author_role.role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_author_role.role_id
     *
     * @param roleId the value for uts_author_role.role_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_author_role.create_time
     *
     * @return the value of uts_author_role.create_time
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_author_role.create_time
     *
     * @param createTime the value for uts_author_role.create_time
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_author_role
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
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