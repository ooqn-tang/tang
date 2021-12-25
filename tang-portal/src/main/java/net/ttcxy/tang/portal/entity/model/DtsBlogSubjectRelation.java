package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsBlogSubjectRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog_subject_relation.blog_subject_relation_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String blogSubjectRelationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog_subject_relation.blog_subject_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String blogSubjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog_subject_relation.blog_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private String blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog_subject_relation.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_blog_subject_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog_subject_relation.blog_subject_relation_id
     *
     * @return the value of dts_blog_subject_relation.blog_subject_relation_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getBlogSubjectRelationId() {
        return blogSubjectRelationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog_subject_relation.blog_subject_relation_id
     *
     * @param blogSubjectRelationId the value for dts_blog_subject_relation.blog_subject_relation_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setBlogSubjectRelationId(String blogSubjectRelationId) {
        this.blogSubjectRelationId = blogSubjectRelationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog_subject_relation.blog_subject_id
     *
     * @return the value of dts_blog_subject_relation.blog_subject_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getBlogSubjectId() {
        return blogSubjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog_subject_relation.blog_subject_id
     *
     * @param blogSubjectId the value for dts_blog_subject_relation.blog_subject_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setBlogSubjectId(String blogSubjectId) {
        this.blogSubjectId = blogSubjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog_subject_relation.blog_id
     *
     * @return the value of dts_blog_subject_relation.blog_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public String getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog_subject_relation.blog_id
     *
     * @param blogId the value for dts_blog_subject_relation.blog_id
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog_subject_relation.create_date
     *
     * @return the value of dts_blog_subject_relation.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog_subject_relation.create_date
     *
     * @param createDate the value for dts_blog_subject_relation.create_date
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog_subject_relation
     *
     * @mbg.generated Sat Dec 25 13:36:32 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogSubjectRelationId=").append(blogSubjectRelationId);
        sb.append(", blogSubjectId=").append(blogSubjectId);
        sb.append(", blogId=").append(blogId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}