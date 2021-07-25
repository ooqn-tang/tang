package net.ttcxy.tang.portal.core.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ttcxy.tang.portal.core.security.jwt.JwtFilter;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.param.UtsLoginParam;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 控制器对用户进行认证。
 */
@RestController
@RequestMapping("/api")
public class AuthenticationRestController {

   private final TokenProvider tokenProvider;

   private final AuthenticationManagerBuilder authenticationManagerBuilder;

   public AuthenticationRestController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
      this.tokenProvider = tokenProvider;
      this.authenticationManagerBuilder = authenticationManagerBuilder;
   }

   @PostMapping("/authenticate")
   public ResponseEntity<JwtToken> authorize(@Valid @RequestBody UtsLoginParam loginParam) {

      UsernamePasswordAuthenticationToken authenticationToken =
         new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());

      Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);

      boolean rememberMe = loginParam.getRememberMe() != null && loginParam.getRememberMe();
      String jwt = tokenProvider.createToken(authentication, rememberMe);

      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

      return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
   }

   @GetMapping("/user")
   public ResponseEntity<CurrentAuthor> getActualUser() {
      return ResponseEntity.ok(CurrentUtil.author());
   }

   /**
    * JWT Authentication.
    */
   static class JwtToken {

      private String jwtToken;

      JwtToken(String jwtToken) {
         this.jwtToken = jwtToken;
      }

      @JsonProperty("jwt_token")
      String getJwtToken() {
         return jwtToken;
      }

      void setJwtToken(String jwtToken) {
         this.jwtToken = jwtToken;
      }
   }
}
