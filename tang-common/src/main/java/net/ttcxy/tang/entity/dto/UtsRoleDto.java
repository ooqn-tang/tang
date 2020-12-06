package net.ttcxy.tang.entity.dto;

import lombok.EqualsAndHashCode;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.Objects;

/**
 * 角色
 * @author huanglei
 */
@EqualsAndHashCode
public class UtsRoleDto implements GrantedAuthority, ConfigAttribute {

    static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String value;

    private Date createTime;

    public UtsRoleDto(){

    }
    public UtsRoleDto(String value){
        this.value = value;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + value;
    }

    @Override
    public String getAttribute() {
        return "ROLE_" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UtsRoleDto)) {
            return false;
        }
        UtsRoleDto that = (UtsRoleDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getValue(), that.getValue()) &&
                Objects.equals(getCreateTime(), that.getCreateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getValue(), getCreateTime());
    }
}
