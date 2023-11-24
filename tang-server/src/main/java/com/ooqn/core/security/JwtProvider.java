package com.ooqn.core.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooqn.core.propertie.TangProperties;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.dto.UtsAuthorRoleDto;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;

import io.jsonwebtoken.Claims;
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
	public String createToken(UtsAuthor author, boolean rememberMe) {
		long now = (new Date()).getTime();
		Date validity;
		if (rememberMe) {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSecondsForRememberMe());
		} else {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSeconds());
		}
		return Jwts.builder().setSubject(author.getUsername())
				.signWith(key, SignatureAlgorithm.HS512).setExpiration(validity).compact();
	}

	/**
	 * 通过Token获取用户信息。
	 * 
	 * @param token
	 * @return 用户上下文 Authentication
	 */
	public String getAuthentication(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * 严重JWT
	 * 
	 * @param authToken
	 * @return
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("无效的JWT签名.");
		} catch (ExpiredJwtException e) {
			log.info("无效的JWT签名.");
		} catch (UnsupportedJwtException e) {
			log.info("不支持的JWT令牌.");
		} catch (IllegalArgumentException e) {
			log.info("处理程序的JWT令牌压缩无效.");
		}
		return false;
	}
}
