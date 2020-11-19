package net.ttcxy.tang.code.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
@ConfigurationProperties(prefix = "tang.app")
public class TangProperties {

}
