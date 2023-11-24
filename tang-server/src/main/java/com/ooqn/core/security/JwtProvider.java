package com.ooqn.core.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ooqn.core.propertie.TangProperties;
import com.ooqn.entity.model.UtsAuthor;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.java.Log;

/**
 * JWT生成器。创建JWT,解析JWT。验证JWT。验证用户身份。
 */
@Log
@Component
public class JwtProvider implements InitializingBean {

	@Autowired
	private TangProperties tangProperties;

	private Key key;

	@Override
	public void afterPropertiesSet() {
		byte[] keyBytes = Decoders.BASE64.decode(tangProperties.getJwt().getBase64Secret());
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	/**
	 * 创建JWT。描述JWT。使用HS256加密算法。加密前传入用户名、令牌、过期时
	 * {tangProperties.getJwt().getTokenValidityInSecondsForRememberMe()}
	 * 
	 * @param details
	 * @param rememberMe
	 * @return
	 */
	public String createJwt(UtsAuthor author, boolean rememberMe) {
		long now = (new Date()).getTime();
		Date validity;
		if (rememberMe) {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSecondsForRememberMe());
		} else {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSeconds());
		}
		return Jwts.builder().setSubject(author.getUsername())
				.signWith(key, SignatureAlgorithm.HS512)
				.setExpiration(validity)
				.compact();
	}

	/**
	 * 通过Token获取用户信息。
	 * 
	 * @param jwt
	 * @return 用户上下文 Authentication
	 */
	public String getAuthentication(String jwt) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(jwt)
				.getBody()
				.getSubject();
	}

	/**
	 * 严重JWT
	 * 
	 * @param jwt
	 * @return
	 */
	public boolean validateJwt(String jwt) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("无效的JWT签名：" + e.getMessage());
		} catch (ExpiredJwtException e) {
			log.info("无效的JWT签名：" + e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.info("不支持的JWT令牌：" + e.getMessage());
		} catch (IllegalArgumentException e) {
			log.info("处理程序的JWT令牌压缩无效：" + e.getMessage());
		} catch (RuntimeException e) {
			log.info("其他异常：" + e.getMessage());
		}
		return false;
	}
}
