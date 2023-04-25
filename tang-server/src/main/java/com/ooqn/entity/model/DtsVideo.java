package com.ooqn.entity.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "通用返回对象")
public class DtsVideo {
    
    @Id
    private String id;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "作者ID")
    private String authorId;

    @Schema(description = "分类ID")
    private String categoryId;

    @Schema(description = "状态")
	private Integer state;

	@Schema(description = "概要")
	private String synopsis;

    @Schema(description = "创建时间")
    private String createTime;

    @Schema(description = "更新时间")
    private String updateTime;
    
}
