package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsBlogSubjectRelation implements Serializable {
    private String blogSubjectRelationId;

    @ApiModelProperty(value = "专题ID")
    private String blogSubjectId;

    @ApiModelProperty(value = "博客ID")
    private String blogId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getBlogSubjectRelationId() {
        return blogSubjectRelationId;
    }

    public void setBlogSubjectRelationId(String blogSubjectRelationId) {
        this.blogSubjectRelationId = blogSubjectRelationId;
    }

    public String getBlogSubjectId() {
        return blogSubjectId;
    }

    public void setBlogSubjectId(String blogSubjectId) {
        this.blogSubjectId = blogSubjectId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
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
        sb.append(", blogSubjectRelationId=").append(blogSubjectRelationId);
        sb.append(", blogSubjectId=").append(blogSubjectId);
        sb.append(", blogId=").append(blogId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}