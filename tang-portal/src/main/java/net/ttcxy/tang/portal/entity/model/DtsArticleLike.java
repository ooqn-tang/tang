package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleLike implements Serializable {
    private String likeArticleId;

    private String authorId;

    private String articleId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getLikeArticleId() {
        return likeArticleId;
    }

    public void setLikeArticleId(String likeArticleId) {
        this.likeArticleId = likeArticleId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", likeArticleId=").append(likeArticleId);
        sb.append(", authorId=").append(authorId);
        sb.append(", articleId=").append(articleId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}