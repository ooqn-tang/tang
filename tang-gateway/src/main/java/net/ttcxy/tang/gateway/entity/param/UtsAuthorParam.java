package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author huanglei
 */
@Data
public class UtsAuthorParam {

    private String id;

    private String username;

    private String nickname;

    @Pattern(regexp = "(?=.*?[a-z])(?=.*?[0-9]){8,25}",message = "密码长度在8~25之间并包含数字字母")
    private String password;

    @Email(message = "邮箱格式不正确")
    private String mail;

    @Size(max = 50,message = "签名长度为50")
    private String signature;

}