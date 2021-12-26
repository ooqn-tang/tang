package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticle implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.article_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private String articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.title
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.author_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.create_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.update_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.state_code
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private Integer stateCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_article.synopsis
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private String synopsis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_article
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.article_id
     *
     * @return the value of dts_article.article_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.article_id
     *
     * @param articleId the value for dts_article.article_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.title
     *
     * @return the value of dts_article.title
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.title
     *
     * @param title the value for dts_article.title
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.author_id
     *
     * @return the value of dts_article.author_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.author_id
     *
     * @param authorId the value for dts_article.author_id
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.create_date
     *
     * @return the value of dts_article.create_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.create_date
     *
     * @param createDate the value for dts_article.create_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.update_date
     *
     * @return the value of dts_article.update_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.update_date
     *
     * @param updateDate the value for dts_article.update_date
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.state_code
     *
     * @return the value of dts_article.state_code
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public Integer getStateCode() {
        return stateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.state_code
     *
     * @param stateCode the value for dts_article.state_code
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_article.synopsis
     *
     * @return the value of dts_article.synopsis
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_article.synopsis
     *
     * @param synopsis the value for dts_article.synopsis
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_article
     *
     * @mbg.generated Sun Dec 26 21:34:36 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", title=").append(title);
        sb.append(", authorId=").append(authorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", stateCode=").append(stateCode);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}