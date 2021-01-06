package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import net.ttcxy.tang.code.exception.ErrorCodeException;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.OAuthTokenService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.mapper.UtsGithubLoginMapper;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsGithubLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OAuthTokenServiceGithubImpl implements OAuthTokenService {

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.client_secret}")
    private String clientSecret;

    private static final String tokenUrl = "https://github.com/login/oauth/access_token";

    private static final String userUrl = "https://api.github.com/user";

    @Autowired
    private UtsGithubLoginMapper utsGithubLoginMapper;

    @Autowired
    private UtsAuthorService utsAuthorService;

    @Override
    public UtsAuthorLogin loadAuthor(String code) throws ErrorCodeException {

        Map<String,Object> param = new HashMap<>();
        param.put("client_id",clientId);
        param.put("client_secret",clientSecret);
        param.put("code",code);
        String post = HttpUtil.post(tokenUrl, param);
        post = ("{'" + post +"'}").replaceAll("=","':'").replaceAll("&","','");
        String token = JSONUtil.parseObj(post).getStr("access_token");

        if (token == null){
            return null;
        }

        HttpRequest httpRequest = new HttpRequest(userUrl);
        httpRequest.header("Authorization","token " + token);
        HttpResponse execute = httpRequest.execute();
        System.out.println(execute.body());
        JSONObject jsonObject = JSONUtil.parseObj(execute.body());
        String id = jsonObject.getStr("id");
        String htmlUrl = jsonObject.getStr("html_url");

        if (StrUtil.isAllBlank(id,htmlUrl)){
            return null;
        }

        UtsAuthorLogin utsAuthorLogin = new UtsAuthorLogin();
        UtsGithubLogin utsGithubLogin = utsGithubLoginMapper.selectByPrimaryKey(id);
        if (utsGithubLogin == null){
            UtsAuthor utsAuthor = createAuthorAndGithubLogin(id, htmlUrl);
            BeanUtil.copyProperties(utsAuthor,utsAuthorLogin);
        }else{
            String authorId = utsGithubLogin.getAuthorId();
            UtsAuthor author = utsAuthorMapper.selectByPrimaryKey(authorId);
            BeanUtil.copyProperties(author,utsAuthorLogin);
        }
        return utsAuthorLogin;
    }

    @Autowired
    UtsAuthorMapper utsAuthorMapper;

    @Override
    public UtsAuthor createAuthorAndGithubLogin(String githubId,String host){

        UtsAuthor utsAuthor = new UtsAuthor();
        int count = utsAuthorService.insertAuthor(utsAuthor);

        if (count > 0){
            String authorId = utsAuthor.getId();
            UtsGithubLogin utsGithubLogin = new UtsGithubLogin();
            utsGithubLogin.setGithubId(githubId);
            utsGithubLogin.setGithubUrl(host);
            utsGithubLogin.setAuthorId(authorId);
            int insertGithubCount = utsGithubLoginMapper.insert(utsGithubLogin);
            if (insertGithubCount > 0){
                return utsAuthor;
            }
        }

        return null;
    }
}
