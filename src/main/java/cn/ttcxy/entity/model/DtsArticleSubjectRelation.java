package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleSubjectRelation implements Serializable {
    private String articleSubjectRelationId;

    private String articleSubjectId;

    private String articleId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getArticleSubjectRelationId() {
        return articleSubjectRelationId;
    }

    public void setArticleSubjectRelationId(String articleSubjectRelationId) {
        this.articleSubjectRelationId = articleSubjectRelationId;
    }

    public String getArticleSubjectId() {
        return articleSubjectId;
    }

    public void setArticleSubjectId(String articleSubjectId) {
        this.articleSubjectId = articleSubjectId;
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
        sb.append(", articleSubjectRelationId=").append(articleSubjectRelationId);
        sb.append(", articleSubjectId=").append(articleSubjectId);
        sb.append(", articleId=").append(articleId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}