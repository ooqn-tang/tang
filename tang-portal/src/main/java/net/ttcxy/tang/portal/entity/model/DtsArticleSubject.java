package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleSubject implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.article_subject_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String articleSubjectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.subject_name
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String subjectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.author_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.order_num
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private Integer orderNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.create_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.update_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_subject.synopsis
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private String synopsis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_article_subject
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.article_subject_id
     *
     * @return the value of dts_article_subject.article_subject_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getArticleSubjectId() {
        return articleSubjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.article_subject_id
     *
     * @param articleSubjectId the value for dts_article_subject.article_subject_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setArticleSubjectId(String articleSubjectId) {
        this.articleSubjectId = articleSubjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.subject_name
     *
     * @return the value of dts_article_subject.subject_name
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.subject_name
     *
     * @param subjectName the value for dts_article_subject.subject_name
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.author_id
     *
     * @return the value of dts_article_subject.author_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.author_id
     *
     * @param authorId the value for dts_article_subject.author_id
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.order_num
     *
     * @return the value of dts_article_subject.order_num
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.order_num
     *
     * @param orderNum the value for dts_article_subject.order_num
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.create_date
     *
     * @return the value of dts_article_subject.create_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.create_date
     *
     * @param createDate the value for dts_article_subject.create_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.update_date
     *
     * @return the value of dts_article_subject.update_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.update_date
     *
     * @param updateDate the value for dts_article_subject.update_date
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_subject.synopsis
     *
     * @return the value of dts_article_subject.synopsis
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_subject.synopsis
     *
     * @param synopsis the value for dts_article_subject.synopsis
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_subject
     *
     * @mbg.generated Sun Jan 02 18:18:55 CST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleSubjectId=").append(articleSubjectId);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", authorId=").append(authorId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}