package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsClass {

	@Id
	private String classId;

	private String className;

	private Date createTime;

	private String type;
}
