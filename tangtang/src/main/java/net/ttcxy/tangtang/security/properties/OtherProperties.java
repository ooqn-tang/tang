package net.ttcxy.tangtang.security.properties;

import cn.hutool.extra.mail.MailAccount;

/**
 * @author ：HuangLei
 * @date ：2020/4/14 0014 15:45
 */
public class OtherProperties {

    private String host = "smtp.163.com";

    private Integer port = 25;

    private Boolean auth = true;

    private String from;

    private String user;

    private String pass;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
