package com.ooqn.entity.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class DtsArticleParam {

	private String articleId;

	@NotBlank
	@Length(min = 1, max = 150, message = "长度在1 ~ 150之间")
	private String title;

	@NotBlank
	@Length(min = 1, max = 200, message = "长度在1 ~ 200之间")
	private String synopsis;

	@NotBlank
	private String text;

	@NotBlank
	private String markdown;

	private String subjectId;

	private String classId;
}
