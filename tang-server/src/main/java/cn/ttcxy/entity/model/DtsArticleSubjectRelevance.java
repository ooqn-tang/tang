package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
