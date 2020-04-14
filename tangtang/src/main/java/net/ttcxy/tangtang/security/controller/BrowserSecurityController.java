package net.ttcxy.tangtang.security.controller;

import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.entity.dto.User;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

        if (!response.getHeaderNames().contains("X-Requested-With")){
            redirectStrategy.sendRedirect(request,response,"/login.html");
        }

        return ResponseData.successful("退出登陆成功");
    }


    @Autowired
    AuthDetailsImpl authDetails;

    @GetMapping("/login.html")
    public String toLogin(){
        User user = authDetails.getUser();
        if (user!=null){
            return "redirect:/";
        }
        return "login";
    }
}
