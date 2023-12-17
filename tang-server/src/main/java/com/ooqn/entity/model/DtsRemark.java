package com.ooqn.entity.model;


import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "评论")
public class DtsRemark {
    
    @Id
    @Column(length = 32)
    private String remarkId;

    @Column(length = 32)
    private String dataId;

    @Column(length = 32)
    private String authorId;

    private String text;

    private Date createTime;

    private Date updateTime;
}
