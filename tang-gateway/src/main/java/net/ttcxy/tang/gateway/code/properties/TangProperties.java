package net.ttcxy.tang.gateway.code.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
@ConfigurationProperties(prefix = "tang.app")
public class TangProperties {

    /**
     * API相关配置
     */
    private CloudProperties cloud = new CloudProperties();

    /**
     * 系统配置
     */
    private SysConfigProperties sys = new SysConfigProperties();

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
