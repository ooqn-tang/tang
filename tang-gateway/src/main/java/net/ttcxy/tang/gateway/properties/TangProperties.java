package net.ttcxy.tang.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by huanglei on 2020/10/10
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
