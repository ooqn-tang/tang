package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class UtsRole {
    
    @Id
    private String roleId;

    private String roleName;

    private String roleValue;

    private Date createTime;

    private Date updateTime;

    private Date refreshTime;

}