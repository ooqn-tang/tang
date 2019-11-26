package net.ttcxy.tangtang.security.properties;

public class MailCodeProperties {

    private int length = 4;
    private int expireIn = 60;
    private int disturb = 100;
    private String urls = "";

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public int getDisturb() {
        return disturb;
    }

    public void setDisturb(int disturb) {
        this.disturb = disturb;
    }
}
