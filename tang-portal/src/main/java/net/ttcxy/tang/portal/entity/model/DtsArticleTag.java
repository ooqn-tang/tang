package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class DtsArticleTag implements Serializable {
    private String articleTagId;

    private String tagName;

    private String synopsis;

    private Date createDate;

    private Integer orderNum;

    private static final long serialVersionUID = 1L;

    public String getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(String articleTagId) {
        this.articleTagId = articleTagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleTagId=").append(articleTagId);
        sb.append(", tagName=").append(tagName);
        sb.append(", synopsis=").append(synopsis);
        sb.append(", createDate=").append(createDate);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}