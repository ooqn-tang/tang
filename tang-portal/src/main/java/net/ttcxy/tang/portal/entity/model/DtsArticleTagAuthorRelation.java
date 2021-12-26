package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleTagAuthorRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_tag_author_relation.article_tag_author_relation_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String articleTagAuthorRelationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_tag_author_relation.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_tag_author_relation.article_tag_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private String articleTagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article_tag_author_relation.create_date
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_tag_author_relation.article_tag_author_relation_id
     *
     * @return the value of dts_article_tag_author_relation.article_tag_author_relation_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getArticleTagAuthorRelationId() {
        return articleTagAuthorRelationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_tag_author_relation.article_tag_author_relation_id
     *
     * @param articleTagAuthorRelationId the value for dts_article_tag_author_relation.article_tag_author_relation_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setArticleTagAuthorRelationId(String articleTagAuthorRelationId) {
        this.articleTagAuthorRelationId = articleTagAuthorRelationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_tag_author_relation.author_id
     *
     * @return the value of dts_article_tag_author_relation.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_tag_author_relation.author_id
     *
     * @param authorId the value for dts_article_tag_author_relation.author_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_tag_author_relation.article_tag_id
     *
     * @return the value of dts_article_tag_author_relation.article_tag_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public String getArticleTagId() {
        return articleTagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_tag_author_relation.article_tag_id
     *
     * @param articleTagId the value for dts_article_tag_author_relation.article_tag_id
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setArticleTagId(String articleTagId) {
        this.articleTagId = articleTagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article_tag_author_relation.create_date
     *
     * @return the value of dts_article_tag_author_relation.create_date
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article_tag_author_relation.create_date
     *
     * @param createDate the value for dts_article_tag_author_relation.create_date
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article_tag_author_relation
     *
     * @mbg.generated Sun Dec 26 20:04:15 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleTagAuthorRelationId=").append(articleTagAuthorRelationId);
        sb.append(", authorId=").append(authorId);
        sb.append(", articleTagId=").append(articleTagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}