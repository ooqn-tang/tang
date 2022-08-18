package cn.ttcxy.entity.propertie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtProperties {

    private String base64Secret;

    private Long tokenValidityInSeconds;

    private Long tokenValidityInSecondsForRememberMe;
}
