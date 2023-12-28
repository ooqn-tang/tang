package com.ooqn.core.propertie;

import java.security.Key;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "tang")
@Order(1)
public class TangProperties implements InitializingBean {

	private String tokenKey = "token";

	private String authorKey = "author";

	private String authoritiesKey = "roles";

	private String openUrl = "";

	private String port = "8888";

	private String base64Secret;

	private Long tokenValidityInSeconds;

	private Long tokenValidityInSecondsForRememberMe;
	
	private Key key;

	@Override
	public void afterPropertiesSet() throws Exception {
		byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
}
