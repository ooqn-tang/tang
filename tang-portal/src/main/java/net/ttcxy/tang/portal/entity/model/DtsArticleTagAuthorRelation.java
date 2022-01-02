package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleTagAuthorRelation implements Serializable {
    private String articleTagAuthorRelationId;

    private String authorId;

    private String articleTagId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getArticleTagAuthorRelationId() {
        return articleTagAuthorRelationId;
    }

    public void setArticleTagAuthorRelationId(String articleTagAuthorRelationId) {
        this.articleTagAuthorRelationId = articleTagAuthorRelationId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(String articleTagId) {
        this.articleTagId = articleTagId;
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
        sb.append(", articleTagAuthorRelationId=").append(articleTagAuthorRelationId);
        sb.append(", authorId=").append(authorId);
        sb.append(", articleTagId=").append(articleTagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}