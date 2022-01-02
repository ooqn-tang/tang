package net.ttcxy.tang.portal.entity.model.gen;

import java.io.Serializable;
import java.util.Date;

public abstract class UtsRoleGen implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_role.role_name
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_role.role_value
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    private String roleValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_role.role_id
     *
     * @return the value of uts_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_role.role_id
     *
     * @param roleId the value for uts_role.role_id
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_role.role_name
     *
     * @return the value of uts_role.role_name
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_role.role_name
     *
     * @param roleName the value for uts_role.role_name
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_role.role_value
     *
     * @return the value of uts_role.role_value
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public String getRoleValue() {
        return roleValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_role.role_value
     *
     * @param roleValue the value for uts_role.role_value
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_role.create_time
     *
     * @return the value of uts_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_role.create_time
     *
     * @param createTime the value for uts_role.create_time
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_role
     *
     * @mbg.generated Sun Jan 02 18:18:18 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleValue=").append(roleValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}