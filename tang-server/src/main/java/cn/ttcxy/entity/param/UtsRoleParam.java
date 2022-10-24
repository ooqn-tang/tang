package cn.ttcxy.entity.param;

import java.util.Date;
import lombok.Data;

@Data
public class UtsRoleParam {

	// id
	private String roleId;

	// 中文名称
	private String roleName;

	// 角色值，需要为字母，推荐为中文拼音
	private String roleValue;

	// 创建时间
	private Date createTime;
}
