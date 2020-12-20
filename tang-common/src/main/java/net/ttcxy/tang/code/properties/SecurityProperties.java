package net.ttcxy.tang.code.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author huanglei
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
    private String formLoginApi = "/doLogin";

    /**
     * 需要验证的
     */
    private String[] verifyUri = {formLoginApi};

    /**
     * token有效时间
     */
    private int tokenTime = 2592000;

    private String[] openUrls;

}
