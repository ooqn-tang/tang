package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class StsConfig implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sts_config.config_id
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    private String configId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sts_config.config_name
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    private String configName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sts_config.data
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    private String data;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sts_config.create_date
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sts_config
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sts_config.config_id
     *
     * @return the value of sts_config.config_id
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public String getConfigId() {
        return configId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sts_config.config_id
     *
     * @param configId the value for sts_config.config_id
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public void setConfigId(String configId) {
        this.configId = configId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sts_config.config_name
     *
     * @return the value of sts_config.config_name
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sts_config.config_name
     *
     * @param configName the value for sts_config.config_name
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sts_config.data
     *
     * @return the value of sts_config.data
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public String getData() {
        return data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sts_config.data
     *
     * @param data the value for sts_config.data
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sts_config.create_date
     *
     * @return the value of sts_config.create_date
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sts_config.create_date
     *
     * @param createDate the value for sts_config.create_date
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sts_config
     *
     * @mbg.generated Sat Nov 20 17:32:51 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configId=").append(configId);
        sb.append(", configName=").append(configName);
        sb.append(", data=").append(data);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}