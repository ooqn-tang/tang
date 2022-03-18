package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleTagRelation implements Serializable {
    private String articleTagRelationId;

    private String articleId;

    private String articleTagId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getArticleTagRelationId() {
        return articleTagRelationId;
    }

    public void setArticleTagRelationId(String articleTagRelationId) {
        this.articleTagRelationId = articleTagRelationId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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
        sb.append(", articleTagRelationId=").append(articleTagRelationId);
        sb.append(", articleId=").append(articleId);
        sb.append(", articleTagId=").append(articleTagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}