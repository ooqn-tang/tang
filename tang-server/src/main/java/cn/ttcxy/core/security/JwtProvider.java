package cn.ttcxy.core.security;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.entity.dto.UtsAuthorDto;
import cn.ttcxy.entity.propertie.TangProperties;
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

	public String createToken(Object details, boolean rememberMe) {
		UserDetails userDetails = (UserDetails) details;
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		UtsAuthorDto authorDto = (UtsAuthorDto) userDetails;

		long now = (new Date()).getTime();
		Date validity;
		if (rememberMe) {
			validity = new Date(
					now + tangProperties.getJwt().getTokenValidityInSecondsForRememberMe());
		} else {
			validity = new Date(now + tangProperties.getJwt().getTokenValidityInSeconds());
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (GrantedAuthority authority : authorities) {
			stringBuilder.append(authority.getAuthority());
			stringBuilder.append(",");
		}
		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}

		return Jwts.builder().setSubject(authorDto.getUsername())
				.claim(tangProperties.getAuthoritiesKey(), stringBuilder)
				.claim(tangProperties.getAuthorKey(), authorDto)
				.signWith(key, SignatureAlgorithm.HS512).setExpiration(validity).compact();
	}

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

	public boolean validateToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("Invalid JWT signature.");
		} catch (ExpiredJwtException e) {
			log.info("Expired JWT token.");
		} catch (UnsupportedJwtException e) {
			log.info("Unsupported JWT token.");
		} catch (IllegalArgumentException e) {
			log.info("JWT token compact of handler are invalid.");
		}
		return false;
	}
}
