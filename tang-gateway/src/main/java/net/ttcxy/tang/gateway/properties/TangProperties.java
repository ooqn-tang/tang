package net.ttcxy.tang.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
@ConfigurationProperties(prefix = "tang")
public class TangProperties {

    /**
     * 安全相关配置
     */
    SpringSecurityProperties security = new SpringSecurityProperties();

    /**
     * API相关配置
     */
    CloudProperties cloud = new CloudProperties();

    /**
     * 系统配置
     */
    SysConfigProperties sys = new SysConfigProperties();

    public SpringSecurityProperties getSecurity() {
        return security;
    }

    public void setSecurity(SpringSecurityProperties security) {
        this.security = security;
    }

    public CloudProperties getCloud() {
        return cloud;
    }

    public void setCloud(CloudProperties cloud) {
        this.cloud = cloud;
    }

    public SysConfigProperties getSys() {
        return sys;
    }

    public void setSys(SysConfigProperties sys) {
        this.sys = sys;
    }
}
