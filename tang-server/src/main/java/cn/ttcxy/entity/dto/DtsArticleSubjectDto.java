package cn.ttcxy.entity.dto;

import java.util.List;

import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsArticleSubjectDto {

	private DtsArticleSubject subject;

	private List<DtsArticle> articleList;
	
}
