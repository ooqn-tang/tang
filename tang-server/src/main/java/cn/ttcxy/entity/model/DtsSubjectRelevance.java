package cn.ttcxy.entity.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DtsSubjectRelevance {

	@Id
	private String subjectRelevanceId;

	private String dataId;

	private String subjectId;

	private Integer orderNum;
	
	private String createAuthorId;

	private Date createDate;

}
