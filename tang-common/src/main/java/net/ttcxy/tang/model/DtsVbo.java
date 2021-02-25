package net.ttcxy.tang.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsVbo implements Serializable {
    private String uuid;

    private String utsAuthorUsername;

    private Date createDate;

    private Date updateDate;

    private String vboText;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUtsAuthorUsername() {
        return utsAuthorUsername;
    }

    public void setUtsAuthorUsername(String utsAuthorUsername) {
        this.utsAuthorUsername = utsAuthorUsername;
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

    public String getVboText() {
        return vboText;
    }

    public void setVboText(String vboText) {
        this.vboText = vboText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", utsAuthorUsername=").append(utsAuthorUsername);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", vboText=").append(vboText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}