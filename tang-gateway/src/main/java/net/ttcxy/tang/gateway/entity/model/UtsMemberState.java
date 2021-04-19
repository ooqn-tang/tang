package net.ttcxy.tang.gateway.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UtsMemberState implements Serializable {
    private Integer memberStateId;

    private String name;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getMemberStateId() {
        return memberStateId;
    }

    public void setMemberStateId(Integer memberStateId) {
        this.memberStateId = memberStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        sb.append(", memberStateId=").append(memberStateId);
        sb.append(", name=").append(name);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}