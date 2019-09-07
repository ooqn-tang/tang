package com.jnnvc.vblog.security.properties;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ConfigurationProperties(prefix = "my.security")
public class SecurityProperties {

    private BrowserProperties browser =  new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private String intercept = "";

    public String[] getIntercept() {
        return StrUtil.splitToArray(intercept,',');
    }

    public void setIntercept(String intercept) {
        this.intercept = intercept;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        System.out.println(browser);
        this.browser = browser;
    }
}
