package net.ttcxy.tang.portal.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UtsRePasswordParam {

    @ApiModelProperty(value = "用户密码")
    @Size(min = 8,max = 30,message = "密码长度 8~30 位")
    private String password;

    @ApiModelProperty(value = "邮箱号")
    @Email(message = "邮箱不正确")
    private String mail;

    @NotBlank
    @Size(min = 4,max = 4)
    @ApiModelProperty("验证码")
    private String code;
}
