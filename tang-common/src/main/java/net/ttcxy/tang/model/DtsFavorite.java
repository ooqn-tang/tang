package net.ttcxy.tang.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsFavorite implements Serializable {
    private String authorId;

    private String vboId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getVboId() {
        return vboId;
    }

    public void setVboId(String vboId) {
        this.vboId = vboId;
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
        sb.append(", authorId=").append(authorId);
        sb.append(", vboId=").append(vboId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}