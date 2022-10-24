package cn.ttcxy.entity.propertie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "tang")
public class TangProperties {

  private String tokenKey = "token";

  private String authorKey = "author";

  private String authoritiesKey = "roles";

  private String openUrl = "";

  private JwtProperties jwt = new JwtProperties();
}
