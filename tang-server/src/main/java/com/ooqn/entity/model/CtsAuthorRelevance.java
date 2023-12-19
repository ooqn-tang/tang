package com.ooqn.entity.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CtsAuthorRelevance {
    
    @Id
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String authorId;

    @Column(length = 32)
    private String beAuthorId;

    // 1 表示申请，2表示申请通过，3，表示申请不通过，4表示黑名单
    private String status;

    private Date createDate;

    private Date updateDate;
}
