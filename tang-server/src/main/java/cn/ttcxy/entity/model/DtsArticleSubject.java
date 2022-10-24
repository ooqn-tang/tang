package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsArticleSubject {

	@Id
	private String subjectId;

	private String subjectName;

	private String authorId;

	private Integer orderNum;

	private Date createDate;

	private Date updateDate;

	private String synopsis;
}
