package net.ttcxy.tang.entity.param;

/**
 * created by huanglei on 2020/9/24
 */
public class RegisterParam {

    private String mail;

    private String password;

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
