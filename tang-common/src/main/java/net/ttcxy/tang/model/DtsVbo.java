package net.ttcxy.tang.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class DtsVbo implements Serializable {
    private String uuid;

    private String utsAuthorUuid;

    private String vboText;

    private String vboUrl;

    private String vboUrlName;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUtsAuthorUuid() {
        return utsAuthorUuid;
    }

    public void setUtsAuthorUuid(String utsAuthorUuid) {
        this.utsAuthorUuid = utsAuthorUuid;
    }

    public String getVboText() {
        return vboText;
    }

    public void setVboText(String vboText) {
        this.vboText = vboText;
    }

    public String getVboUrl() {
        return vboUrl;
    }

    public void setVboUrl(String vboUrl) {
        this.vboUrl = vboUrl;
    }

    public String getVboUrlName() {
        return vboUrlName;
    }

    public void setVboUrlName(String vboUrlName) {
        this.vboUrlName = vboUrlName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", utsAuthorUuid=").append(utsAuthorUuid);
        sb.append(", vboText=").append(vboText);
        sb.append(", vboUrl=").append(vboUrl);
        sb.append(", vboUrlName=").append(vboUrlName);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}