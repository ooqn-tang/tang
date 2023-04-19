package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StsNotice {

	@Id
	private String noticeId;

	private String title;

	private String url;

	private String description;

	private String type;

	private String status;
	
	private Integer orderNum;


	private String createAuthorId;

	private Date createDate;

}
