package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsBlogTagAuthorRelation implements Serializable {
    private String blogTagAuthorRelationId;

    @ApiModelProperty(value = "作者")
    private String authorId;

    @ApiModelProperty(value = "博客标签ID")
    private String blogTagId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getBlogTagAuthorRelationId() {
        return blogTagAuthorRelationId;
    }

    public void setBlogTagAuthorRelationId(String blogTagAuthorRelationId) {
        this.blogTagAuthorRelationId = blogTagAuthorRelationId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBlogTagId() {
        return blogTagId;
    }

    public void setBlogTagId(String blogTagId) {
        this.blogTagId = blogTagId;
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
        sb.append(", blogTagAuthorRelationId=").append(blogTagAuthorRelationId);
        sb.append(", authorId=").append(authorId);
        sb.append(", blogTagId=").append(blogTagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}