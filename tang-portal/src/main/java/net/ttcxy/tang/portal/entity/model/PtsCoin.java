package net.ttcxy.tang.portal.entity.model;

import java.io.Serializable;
import java.util.Date;

public class PtsCoin implements Serializable {
    private String coinId;

    private Integer coinValue;

    private String authorId;

    private String dataId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public Integer getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Integer coinValue) {
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}