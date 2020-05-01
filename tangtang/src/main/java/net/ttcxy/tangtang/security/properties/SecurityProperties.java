package net.ttcxy.tangtang.security.properties;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.security")
public class SecurityProperties {

    private BrowserProperties browser =  new BrowserProperties();

    private OtherProperties other = new OtherProperties();

    private String intercept = "";

    public OtherProperties getOther() {
        return other;
    }

    public void setOther(OtherProperties other) {
        this.other = other;
    }

    public String[] getIntercept() {
        return StrUtil.splitToArray(intercept,',');
    }

    public void setIntercept(String intercept) {
        this.intercept = intercept;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        System.out.println(browser);
        this.browser = browser;
    }
}
