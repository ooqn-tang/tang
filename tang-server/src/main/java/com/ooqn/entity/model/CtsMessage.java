package com.ooqn.entity.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CtsMessage {
    
    @Id
    @Column(length = 32)
    private String id;

    private String sendName;

    /**
     * 接收名称。群名称，或者用户名称
     */
    private String acceptName;

    private String content;

    private Date createTime;

    private Date updateTime;

}
