package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StsConfig {

	@Id
	private String configId;

	private String configName;

	private String data;

	private Date createDate;
}
