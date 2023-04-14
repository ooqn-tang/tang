package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsCollect {

	@Id
	private String collectId;

	private String authorId;

	private String title;

	private String synopsis;

	private String url;

	private String dataId;

	private Date createDate;
}
