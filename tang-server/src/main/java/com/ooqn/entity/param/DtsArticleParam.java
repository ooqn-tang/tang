package com.ooqn.entity.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

import org.hibernate.validator.constraints.Length;

@Data
public class DtsArticleParam {

	private String articleId;

	@NotBlank
	@Length(min = 1, max = 150, message = "长度在1 ~ 150之间")
	private String title;

	@NotBlank
	private String text;

	private String categoryId;

	@NotBlank
	private String markdown;

	private String subjectId;

	private List<String> tagIdList;
}
