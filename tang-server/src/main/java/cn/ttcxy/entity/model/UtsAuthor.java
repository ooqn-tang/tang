package cn.ttcxy.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

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