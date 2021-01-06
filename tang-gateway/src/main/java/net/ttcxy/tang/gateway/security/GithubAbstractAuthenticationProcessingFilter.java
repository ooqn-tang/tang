package net.ttcxy.tang.gateway.security;

import lombok.SneakyThrows;
import net.ttcxy.tang.code.properties.SecurityProperties;
import net.ttcxy.tang.code.security.TangSecurityConfig;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.OAuthTokenService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.mapper.UtsGithubLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GithubAbstractAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public static final String CODE = "code";

    public GithubAbstractAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/github.login", "GET"));
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Autowired
    private UtsGithubLoginMapper utsGithubLoginMapper;

    @Autowired
    private UtsAuthorMapper utsAuthorMapper;

    @Autowired
    private OAuthTokenService oAuthTokenServiceGithubImpl;

    @Autowired
    private SecurityProperties securityProperties;

    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {



        String code = request.getParameter("code");

        if (code == null){
            code = "";
        }

        UtsAuthorLogin author = oAuthTokenServiceGithubImpl.loadAuthor(code);
        if (author == null){
            return null;
        }

        MyAbstractAuthenticationToken myAbstractAuthenticationToken = new MyAbstractAuthenticationToken(author, author);

        setRememberMeServices(tokenBasedRememberMeServices());

        response.addCookie(new Cookie("remember-me","remember-me"));

        return  myAbstractAuthenticationToken;

    }


    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    TokenBasedRememberMeServices tokenBasedRememberMeServices(){
        return new TokenBasedRememberMeServices("remember-me",userDetailsService);
    }



}
