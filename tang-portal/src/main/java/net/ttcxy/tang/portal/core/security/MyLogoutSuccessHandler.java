package net.ttcxy.tang.portal.core.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出成功实现这个接口
 * @author huanglei
 */
@Slf4j
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(200);
        try {
            response.getWriter().append("退出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("退出成功");
    }
}
