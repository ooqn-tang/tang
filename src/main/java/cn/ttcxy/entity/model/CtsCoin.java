package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class CtsCoin implements Serializable {
    private String coinId;

    private Double coinValue;

    private String authorId;

    private String dataId;

    private Date createTime;

    private String cause;

    private Integer type;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public Double getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Double coinValue) {
        this.coinValue = coinValue;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", coinId=").append(coinId);
        sb.append(", coinValue=").append(coinValue);
        sb.append(", authorId=").append(authorId);
        sb.append(", dataId=").append(dataId);
        sb.append(", createTime=").append(createTime);
        sb.append(", cause=").append(cause);
        sb.append(", type=").append(type);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}