package net.ttcxy.tang.portal.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LYJ
 */
@ConfigurationProperties(prefix = "tang.security")
@Component
@Data
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
    private String formLoginApi = "/api/login";

    /**
     * 需要验证的
     */
    private String[] verifyUri = {formLoginApi};

    /**
     * token有效时间
     */
    private int tokenTime = 2592000;


}
