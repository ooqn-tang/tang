package net.ttcxy.tang.gateway.core.security;

import cn.hutool.json.JSONUtil;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.UtsLoginDto;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 * @author huanglei
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException{
        httpServletResponse.setContentType("application/json;charset=utf-8");
        UtsAuthor author = currentAuthorService.getAuthor();
        author.setPassword(null);
        String jsonStr = JSONUtil.toJsonStr(ResponseResult.success(author));
        httpServletResponse.getWriter().append(jsonStr);
    }
}
