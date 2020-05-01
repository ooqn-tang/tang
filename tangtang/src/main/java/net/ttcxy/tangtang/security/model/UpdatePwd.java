package net.ttcxy.tangtang.security.model;

/**
 * @author ：HuangLei
 * @date ：2020/4/16 0016 17:25
 */
public class UpdatePwd {


    private String password;

    private String yzm;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }
}
