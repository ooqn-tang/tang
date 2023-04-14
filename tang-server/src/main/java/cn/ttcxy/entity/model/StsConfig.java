package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
