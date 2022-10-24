package cn.ttcxy.entity.param;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UtsRePasswordParam {

  // 用户密码")
  @Size(min = 8, max = 30, message = "密码长度 8~30 位")
  private String password;

  // 邮箱号")
  @Email(message = "邮箱不正确")
  private String mail;

  @NotBlank
  @Size(min = 4, max = 4)
  // 验证码")
  private String code;
}
