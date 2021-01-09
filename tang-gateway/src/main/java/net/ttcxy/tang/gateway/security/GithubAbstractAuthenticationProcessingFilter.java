package net.ttcxy.tang.gateway.security;

import lombok.SneakyThrows;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.OAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GithubAbstractAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private static final String CODE = "code";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private OAuthTokenService oAuthTokenServiceGithubImpl;

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    public GithubAbstractAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/github.login", "GET"));
    }

    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String code = request.getParameter(CODE);

        if (code == null){
            code = "";
        }

        UtsAuthorLogin author = oAuthTokenServiceGithubImpl.loadAuthor(code);

        if (author == null){
            return null;
        }
        return new MyAbstractAuthenticationToken(author);
    }
}
