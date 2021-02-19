package net.ttcxy.tang.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UtsWebPath implements Serializable {
    private String uuid;

    private String utsAuthorUuid;

    @ApiModelProperty(value = "网站名")
    private String webName;

    @ApiModelProperty(value = "网站路径")
    private String webPath;

    @ApiModelProperty(value = "网站账户名称、或账户")
    private String addrName;

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

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
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
        sb.append(", webName=").append(webName);
        sb.append(", webPath=").append(webPath);
        sb.append(", addrName=").append(addrName);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}