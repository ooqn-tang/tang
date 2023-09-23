package com.ooqn.entity.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Schema(description = "标签")
public class DtsTag {
    
    @Id
    private String id;

    @Schema(description = "标签名")
    @Column(unique=true)
    private String name;

    @Schema(description = "分类ID")
    private String categoryId;

    @Schema(description = "创建时间")
    private String createTime;

    @Schema(description = "更新时间")
    private String updateTime;


}
