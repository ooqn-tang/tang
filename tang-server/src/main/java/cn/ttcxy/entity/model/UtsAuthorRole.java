package cn.ttcxy.entity.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UtsAuthorRole {

	@Id
	private String authorRoleId;

	private String authorId;

	private String roleId;

	private Date createTime;
}
