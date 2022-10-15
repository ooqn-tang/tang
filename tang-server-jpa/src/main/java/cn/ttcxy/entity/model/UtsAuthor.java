package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class UtsAuthor {
    
    @Id
    private String authorId;

    private String username;

    private String nickname;

    private String password;

    private String mail;

    private String signature;

    private Date updateTime;

    private Date refreshTime;

    private String headUrl;

}