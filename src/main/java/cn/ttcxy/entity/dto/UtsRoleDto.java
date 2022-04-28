package cn.ttcxy.entity.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.Objects;

/**
 * 角色
 */
@Data
public class UtsRoleDto implements GrantedAuthority {

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
    public int hashCode() {
        return Objects.hash(getId(), getName(), getValue(), getCreateTime());
    }
}
