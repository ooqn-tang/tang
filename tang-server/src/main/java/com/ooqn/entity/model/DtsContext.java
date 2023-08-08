package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "文本")
public class DtsContext {

    @Id
    private String id;

    @Schema(description = "所属内容ID")
    private String dataId;

    @Schema(description = "正文")
    private String text;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;
    
}
