package net.ttcxy.tangtang.properties;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
@ConfigurationProperties(prefix = "tangtang")
public class TangTangProperties {

    SpringSecurityProperties security = new SpringSecurityProperties();

    //CloudApiConfig cloudApi = new CloudApiConfig();


    public SpringSecurityProperties getSecurity() {
        return security;
    }

    public void setSecurity(SpringSecurityProperties security) {
        this.security = security;
    }
}
