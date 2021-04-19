package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsBlogComment implements Serializable {
    private String blogCommentId;

    private String blogId;

    private Integer status;

    private String userId;

    private String content;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getBlogCommentId() {
        return blogCommentId;
    }

    public void setBlogCommentId(String blogCommentId) {
        this.blogCommentId = blogCommentId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        sb.append(", blogCommentId=").append(blogCommentId);
        sb.append(", blogId=").append(blogId);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}