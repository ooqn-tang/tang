package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
public class DtsArticle {

	@Id
	private String articleId;

	private String title;

	@Column(updatable = false)
	private String authorId;

	@Column(updatable = false)
	private Date createDate;

	private Date updateDate;

	private Integer state;

	private String synopsis;

	@Lob
	private String text;

	@Lob
	private String markdown;
}
