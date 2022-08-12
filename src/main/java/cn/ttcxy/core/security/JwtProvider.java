package cn.ttcxy.core.security;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.entity.CurrentAuthor;
import cn.ttcxy.entity.propertie.TangProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

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
        CurrentAuthor currentAuthor = (CurrentAuthor) userDetails;

        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + tangProperties.getJwt().getTokenValidityInSecondsForRememberMe());
        } else {
            validity = new Date(now + tangProperties.getJwt().getTokenValidityInSeconds());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            stringBuilder.append(authority.getAuthority());
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return Jwts.builder()
                .setSubject(currentAuthor.getUsername())
                .claim(tangProperties.getAuthoritiesKey(), stringBuilder)
                .claim(tangProperties.getAuthorKey(), currentAuthor)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays
                .stream(claims.get(tangProperties.getAuthoritiesKey()).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        CurrentAuthor principal = BeanUtil.toBean(claims.get(tangProperties.getAuthorKey()),CurrentAuthor.class);

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
