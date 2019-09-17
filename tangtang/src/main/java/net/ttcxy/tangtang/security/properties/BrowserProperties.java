package net.ttcxy.tangtang.security.properties;

public class BrowserProperties {

    private String loginPage = "/login.html";

    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public String toString() {
        return "BrowserProperties{" +
                "loginPage='" + loginPage + '\'' +
                '}';
    }


    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
