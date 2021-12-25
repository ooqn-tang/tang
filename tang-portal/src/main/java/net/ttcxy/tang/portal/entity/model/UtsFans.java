package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsFans implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_fans.fans_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String fansId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_fans.be_author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String beAuthorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_fans.author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uts_fans.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uts_fans
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_fans.fans_id
     *
     * @return the value of uts_fans.fans_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getFansId() {
        return fansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_fans.fans_id
     *
     * @param fansId the value for uts_fans.fans_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_fans.be_author_id
     *
     * @return the value of uts_fans.be_author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getBeAuthorId() {
        return beAuthorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_fans.be_author_id
     *
     * @param beAuthorId the value for uts_fans.be_author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setBeAuthorId(String beAuthorId) {
        this.beAuthorId = beAuthorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_fans.author_id
     *
     * @return the value of uts_fans.author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_fans.author_id
     *
     * @param authorId the value for uts_fans.author_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uts_fans.create_date
     *
     * @return the value of uts_fans.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uts_fans.create_date
     *
     * @param createDate the value for uts_fans.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uts_fans
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fansId=").append(fansId);
        sb.append(", beAuthorId=").append(beAuthorId);
        sb.append(", authorId=").append(authorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}