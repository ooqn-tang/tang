package com.jnnvc.vblog.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置类，所有配置都放入当前包中
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
    private EmailProperties emailProperties = new EmailProperties();

}
