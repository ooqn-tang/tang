package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsBlog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.blog_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.title
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.author_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.create_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.update_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.state_code
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private Integer stateCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.synopsis
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String synopsis;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.text
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String text;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_blog.markdown
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private String markdown;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.blog_id
     *
     * @return the value of dts_blog.blog_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.blog_id
     *
     * @param blogId the value for dts_blog.blog_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.title
     *
     * @return the value of dts_blog.title
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.title
     *
     * @param title the value for dts_blog.title
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.author_id
     *
     * @return the value of dts_blog.author_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.author_id
     *
     * @param authorId the value for dts_blog.author_id
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.create_date
     *
     * @return the value of dts_blog.create_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.create_date
     *
     * @param createDate the value for dts_blog.create_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.update_date
     *
     * @return the value of dts_blog.update_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.update_date
     *
     * @param updateDate the value for dts_blog.update_date
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.state_code
     *
     * @return the value of dts_blog.state_code
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public Integer getStateCode() {
        return stateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.state_code
     *
     * @param stateCode the value for dts_blog.state_code
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.synopsis
     *
     * @return the value of dts_blog.synopsis
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.synopsis
     *
     * @param synopsis the value for dts_blog.synopsis
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.text
     *
     * @return the value of dts_blog.text
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.text
     *
     * @param text the value for dts_blog.text
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dts_blog.markdown
     *
     * @return the value of dts_blog.markdown
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public String getMarkdown() {
        return markdown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dts_blog.markdown
     *
     * @param markdown the value for dts_blog.markdown
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dts_blog
     *
     * @mbg.generated Sun Jul 25 15:28:14 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogId=").append(blogId);
        sb.append(", title=").append(title);
        sb.append(", authorId=").append(authorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", stateCode=").append(stateCode);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", text=").append(text);
        sb.append(", markdown=").append(markdown);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}