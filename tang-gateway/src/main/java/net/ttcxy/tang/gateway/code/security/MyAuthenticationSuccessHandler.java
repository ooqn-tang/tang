package net.ttcxy.tang.gateway.code.security;

import cn.hutool.json.JSONUtil;
import net.ttcxy.tang.gateway.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException{
        httpServletResponse.setContentType("application/json;charset=utf-8");
        UtsAuthorLogin login = (UtsAuthorLogin) authentication.getPrincipal();
        login.setPassword(null);
        String jsonStr = JSONUtil.toJsonStr(ResponseResult.success(login));
        httpServletResponse.getWriter().append(jsonStr);
    }
}
