package net.ttcxy.tang.gateway.security;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import net.ttcxy.tang.model.UtsGithubLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GithubAbstractAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final static String CODE = "code";

    /**
     * 获取 Token 的 API
     */
    private final static String accessTokenUri = "https://github.com/login/oauth/access_token";

    /**
     * 获取 Token 的 API
     */
    private final static String userInfoUri = "https://api.github.com/user";


    protected GithubAbstractAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String code = httpServletRequest.getParameter(CODE);
        Map<String,Object> param = new HashMap<>();
        param.put("client_id","Iv1.a91b223d98f8cf96");
        param.put("client_secret","928cd60408c092e9c920b5980892e3adc886ae98");
        param.put("code",code);
        String post = HttpUtil.post(accessTokenUri, param);
        post = ("{'" + post +"'}").replaceAll("=","':'").replaceAll("&","','");
        System.out.println(post);
        String token = JSONUtil.parseObj(post).getStr("access_token");
        HttpRequest httpRequest = new HttpRequest(userInfoUri);
        httpRequest.header("Authorization","token " + token);
        HttpResponse execute = httpRequest.execute();
        System.out.println(execute.body());
        JSONObject jsonObject = JSONUtil.parseObj(execute.body());
        String login = jsonObject.getStr("name");
        if (StrUtil.isBlank(login)){
            login = jsonObject.getStr("login");
        }
        String htmlUrl = jsonObject.getStr("html_url");


        return null;
    }
}
