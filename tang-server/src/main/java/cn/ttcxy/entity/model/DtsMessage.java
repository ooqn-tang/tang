package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsMessage {

	@Id
	private String messageId;

	private String authorId;

	private String recipientAuthorId;

	private Date createDate;

	private String text;

	private String url;

	private String title;
}
