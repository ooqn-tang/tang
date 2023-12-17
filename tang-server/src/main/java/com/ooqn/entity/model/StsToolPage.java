package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Schema(description = "模板")
public class StsToolPage {

    @Id
    @Column(length = 32)
    private String id;

    @Column(unique=true)
    private String name;

    private String synopsis;

    private Date createTime;

    private Date updateTime;

    @Column(length = 32)
    private String contextId;
    
}
