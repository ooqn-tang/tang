package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
