package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UtsResource {

	@Id
	private String resourceId;

	private String path;

	private String name;

	private String type;

	private Date createTime;

	private Integer state;
}
