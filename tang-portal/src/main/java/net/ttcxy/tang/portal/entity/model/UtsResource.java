package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsResource implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.resource_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.parent_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.path
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.name
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.level
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.type
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_resource.create_time
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uts_resource
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.resource_id
     *
     * @return the value of uts_resource.resource_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.resource_id
     *
     * @param resourceId the value for uts_resource.resource_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.parent_id
     *
     * @return the value of uts_resource.parent_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.parent_id
     *
     * @param parentId the value for uts_resource.parent_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.path
     *
     * @return the value of uts_resource.path
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.path
     *
     * @param path the value for uts_resource.path
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.name
     *
     * @return the value of uts_resource.name
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.name
     *
     * @param name the value for uts_resource.name
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.level
     *
     * @return the value of uts_resource.level
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.level
     *
     * @param level the value for uts_resource.level
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.type
     *
     * @return the value of uts_resource.type
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.type
     *
     * @param type the value for uts_resource.type
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_resource.create_time
     *
     * @return the value of uts_resource.create_time
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_resource.create_time
     *
     * @param createTime the value for uts_resource.create_time
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_resource
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceId=").append(resourceId);
        sb.append(", parentId=").append(parentId);
        sb.append(", path=").append(path);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}