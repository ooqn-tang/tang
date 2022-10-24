package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DtsArticleSubjectRelevance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String articleId;

	private String subjectId;

	private Integer orderNum;

	private Date createDate;
}
