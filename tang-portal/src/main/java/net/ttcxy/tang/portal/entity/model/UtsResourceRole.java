package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsResourceRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource_role.resource_role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String resourceRoleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource_role.resource_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource_role.resource_role_id
     *
     * @return the value of uts_resource_role.resource_role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getResourceRoleId() {
        return resourceRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource_role.resource_role_id
     *
     * @param resourceRoleId the value for uts_resource_role.resource_role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setResourceRoleId(String resourceRoleId) {
        this.resourceRoleId = resourceRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource_role.resource_id
     *
     * @return the value of uts_resource_role.resource_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource_role.resource_id
     *
     * @param resourceId the value for uts_resource_role.resource_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource_role.role_id
     *
     * @return the value of uts_resource_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource_role.role_id
     *
     * @param roleId the value for uts_resource_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource_role.create_time
     *
     * @return the value of uts_resource_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource_role.create_time
     *
     * @param createTime the value for uts_resource_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource_role
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceRoleId=").append(resourceRoleId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", roleId=").append(roleId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}