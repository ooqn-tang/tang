package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsBlogTagRelation implements Serializable {
    private String blogTagRelationId;

    @ApiModelProperty(value = "博客ID")
    private String blogId;

    @ApiModelProperty(value = "博客标签ID")
    private String blogTagId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getBlogTagRelationId() {
        return blogTagRelationId;
    }

    public void setBlogTagRelationId(String blogTagRelationId) {
        this.blogTagRelationId = blogTagRelationId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
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
        sb.append(", blogTagRelationId=").append(blogTagRelationId);
        sb.append(", blogId=").append(blogId);
        sb.append(", blogTagId=").append(blogTagId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}