package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class UtsAuthorRole {
    
    @Id
    private String authorRoleId;

    private String authorId;

    private String roleId;

    private Date createTime;

}