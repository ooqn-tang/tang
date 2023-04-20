package com.ooqn.core.security;

import cn.hutool.core.bean.BeanUtil;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.propertie.TangProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

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
	 * 创建JWT。描述JWT。使用HS256加密算法。加密前传入用户名、令牌、过期时 {tangProperties.getJwt().getTokenValidityInSecondsForRememberMe()} 
	 * @param details
	 * @param rememberMe
	 * @return
	 */
	public String createToken(Object details, boolean rememberMe) {
		UserDetails userDetails = (UserDetails) details;
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		UtsAuthorDto authorDto = (UtsAuthorDto) userDetails;

		long now = (new Date()).getTime();
		Date validity;
		if (rememberMe) {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSecondsForRememberMe());
		} else {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSeconds());
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (GrantedAuthority authority : authorities) {
			stringBuilder.append(",");
			stringBuilder.append(authority.getAuthority());
		}
		
		return Jwts.builder().setSubject(authorDto.getUsername())
				.claim(tangProperties.getAuthoritiesKey(), stringBuilder.substring(1))
				.claim(tangProperties.getAuthorKey(), authorDto)
				.signWith(key, SignatureAlgorithm.HS512).setExpiration(validity).compact();
	}

	/**
	 * 通过Token获取用户信息。
	 * @param token
	 * @return 用户上下文 Authentication
	 */
	public Authentication getAuthentication(String token) {
		Claims claims =
				Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

		Collection<? extends GrantedAuthority> authorities =
				Arrays.stream(claims.get(tangProperties.getAuthoritiesKey()).toString().split(","))
						.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		UtsAuthorDto principal =
				BeanUtil.toBean(claims.get(tangProperties.getAuthorKey()), UtsAuthorDto.class);

		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}

	/**
	 * 严重JWT
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
