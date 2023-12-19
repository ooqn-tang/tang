package com.ooqn.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CtsTeamRelevance {
    
    @Id
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String authorId;

    @Column(length = 32)
    private String teamId;

    // 1 表示申请，2表示申请通过，3，表示申请不通过，4表示黑名单
    private String status;

    // 用户类型 1 表示群主，2表示管理员，3表示普通用户
    private String type;

    // 申请理由
    private String remark;

    private String createTime;

    private String udpateTime;

}
