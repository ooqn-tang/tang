package net.ttcxy.tangtang.security.model;

import net.ttcxy.tangtang.entity.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author ：HuangLei
 * @date ：2020/4/16 0016 11:27
 */
public class Register {

    @NotNull(message = "user 不能为null")
    @Valid
    private User user ;

    @NotNull(message = "yzm不能为null")
    @Length(min = 4,max = 4,message = "验证码长度为4")
    private String yzm;

    @NotNull(message = "token不能为null")
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
