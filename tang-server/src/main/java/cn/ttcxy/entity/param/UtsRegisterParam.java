package cn.ttcxy.entity.param;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 注册参数
 */
@Data
public class UtsRegisterParam {

	// 用户密码
	@Size(min = 8, max = 30, message = "密码长度 8~30 位")
	private String password;

	// 邮箱号
	@Email(message = "邮箱不正确")
	private String mail;
}
