package net.ttcxy.tang.code.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author huanglei
 */
@ConfigurationProperties(prefix = "tang.security")
@Component
public class SecurityProperties {

    private boolean securitySession = true;

    /**
     * 记住登陆
     */
    private boolean rememberMe = false;

    /**
     * 登陆页面
     */
    private String loginPagePath = "/";

    /**
     * 登陆请求
     */
    private String formLoginApi = "/doLogin";

    /**
     * 默认登录请求
     */
    private String[] verifyUri = {formLoginApi};


    /**
     * token有效时间
     */
    private int tokenTime = 2592000;

    private String[] openUrls;

    public String[] getOpenUrls() {
        return openUrls;
    }

    public void setOpenUrls(String[] openUrls) {
        this.openUrls = openUrls;
    }

    public boolean isSecuritySession() {
        return securitySession;
    }

    public void setSecuritySession(boolean securitySession) {
        this.securitySession = securitySession;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getLoginPagePath() {
        return loginPagePath;
    }

    public void setLoginPagePath(String loginPagePath) {
        this.loginPagePath = loginPagePath;
    }

    public String getFormLoginApi() {
        return formLoginApi;
    }

    public void setFormLoginApi(String formLoginApi) {
        this.formLoginApi = formLoginApi;
    }

    public String[] getVerifyUri() {
        return verifyUri;
    }

    public void setVerifyUri(String[] verifyUri) {
        this.verifyUri = verifyUri;
    }

    public int getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(int tokenTime) {
        this.tokenTime = tokenTime;
    }

    @Override
    public String toString() {
        return "SpringSecurityProperties{" +
                "rememberMe=" + rememberMe +
                ", loginPagePath='" + loginPagePath + '\'' +
                ", formLoginApi='" + formLoginApi + '\'' +
                ", tokenTime=" + tokenTime +
                '}';
    }
}
