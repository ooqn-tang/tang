package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticle implements Serializable {
    private String articleId;

    private String title;

    private String authorId;

    private Date createDate;

    private Date updateDate;

    private Integer state;

    private String synopsis;

    private String text1;

    private String markdown1;

    private static final long serialVersionUID = 1L;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getMarkdown1() {
        return markdown1;
    }

    public void setMarkdown1(String markdown1) {
        this.markdown1 = markdown1;
    }

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
        sb.append(", state=").append(state);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", text1=").append(text1);
        sb.append(", markdown1=").append(markdown1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}