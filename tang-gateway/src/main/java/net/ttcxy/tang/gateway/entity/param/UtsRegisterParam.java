package net.ttcxy.tang.gateway.entity.param;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 注册参数
 * @author huanglei
 */
public class UtsRegisterParam {

    @Email(message = "邮箱格式不正确")
    private String mail;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "验证码不为空")
    @Size(message = "验证码长度不正确",max = 4,min = 4)
    private String verify;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
