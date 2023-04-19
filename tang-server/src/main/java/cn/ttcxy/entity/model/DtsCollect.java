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

	private String dataId;

	private String dataType;

	private String synopsis;

	private String url;

	private Date createDate;
}
