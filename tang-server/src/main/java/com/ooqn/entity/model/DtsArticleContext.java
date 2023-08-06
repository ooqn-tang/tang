package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DtsArticleContext {

    @Id
    @Schema(description = "文章ID")
    private String articleId;

    @Lob
	@Schema(description = "正文")
	private String text;

	@Lob
	@Schema(description = "markdown")
	private String markdown;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

}
