package net.ttcxy.tang.portal.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsBlogSubject implements Serializable {
    private String blogSubjectId;

    @ApiModelProperty(value = "标题")
    private String subjectName;

    @ApiModelProperty(value = "作者ID")
    private String authorId;

    @ApiModelProperty(value = "排序号码")
    private Integer orderNum;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    private String synopsis;

    private static final long serialVersionUID = 1L;

    public String getBlogSubjectId() {
        return blogSubjectId;
    }

    public void setBlogSubjectId(String blogSubjectId) {
        this.blogSubjectId = blogSubjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogSubjectId=").append(blogSubjectId);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", authorId=").append(authorId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}