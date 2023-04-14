package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UtsFans {

	@Id
	private String fansId;

	private String beAuthorId;

	private String authorId;

	private Date createDate;
}
