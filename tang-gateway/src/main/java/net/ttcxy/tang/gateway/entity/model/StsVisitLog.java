package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class StsVisitLog implements Serializable {
    private Integer visitLogId;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "IP")
    private String ipAddr;

    @ApiModelProperty(value = "成员ID")
    private Integer memberId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getVisitLogId() {
        return visitLogId;
    }

    public void setVisitLogId(Integer visitLogId) {
        this.visitLogId = visitLogId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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
        sb.append(", visitLogId=").append(visitLogId);
        sb.append(", path=").append(path);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", memberId=").append(memberId);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}