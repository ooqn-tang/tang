package net.ttcxy.tangtang.security.controller;

import cn.hutool.core.util.StrUtil;
import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.security.model.SimpleResponse;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class BrowserSecurityController {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @GetMapping("/authentication/require")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseData GetRequireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!response.getHeaderNames().contains("X-Requested-With"))
            redirectStrategy.sendRedirect(request,response,"/login.html");

        return ResponseData.successful("退出登陆成功");
    }

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/login.html")
    public String toLogin(){
        User user = (User)httpSession.getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);
        if (user!=null){
            return "redirect:/";
        }
        return "login";
    }
}
