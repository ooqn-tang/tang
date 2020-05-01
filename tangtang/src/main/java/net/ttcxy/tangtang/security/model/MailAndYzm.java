package net.ttcxy.tangtang.security.model;

/**
 * @author ：HuangLei
 * @date ：2020/4/16 0016 11:23
 */
public class MailAndYzm {

    public MailAndYzm(String mail, String yzm) {
        this.mail = mail;
        this.yzm = yzm;
    }

    private String mail;

    private String yzm;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }
}
