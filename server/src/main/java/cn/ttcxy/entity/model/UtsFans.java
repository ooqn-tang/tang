package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

public class UtsFans implements Serializable {
    private String fansId;

    private String beAuthorId;

    private String authorId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    public String getBeAuthorId() {
        return beAuthorId;
    }

    public void setBeAuthorId(String beAuthorId) {
        this.beAuthorId = beAuthorId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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
        sb.append(", fansId=").append(fansId);
        sb.append(", beAuthorId=").append(beAuthorId);
        sb.append(", authorId=").append(authorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}