package net.ttcxy.tangtang.security.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Validated
public class BrowserSecurityController {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @GetMapping("/authentication/require")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.FOUND)
    public CommonResult getRequireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!response.getHeaderNames().contains("X-Requested-With")){
            redirectStrategy.sendRedirect(request,response,"/login.html");
        }


        return CommonResult.success("退出登陆成功");
    }


    @Autowired
    AuthDetailsImpl authDetails;

    @GetMapping("/login.html")
    @ResponseStatus(code = HttpStatus.FOUND)
    public String toLogin(){
        User user = authDetails.getUser();
        if (user!=null){
            return "redirect:/";
        }
        return "login";
    }

    /**
     * 注册页面
     * @return register
     */
    @GetMapping({"register.html","register"})
    public String register(){
        return "register";

    }


    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    public CommonResult register(@RequestBody User user){


        if (user==null){
            return CommonResult.failed("参数不正确");
        }else{


            String username = user.getUsername();
            if (username==null||username.length()<5||username.length()>15){
                return CommonResult.failed("用户名长度：5~15");
            }

            String regex = "^[a-z0-9A-Z]+$";
            if(!username.matches(regex)){
                return CommonResult.failed("用户名必须为数字和字母");
            }

            if (userService.selectUsernameIsTrue(username)){
                return CommonResult.failed("用户名已经存在");
            }

            String password = user.getPassword();
            if (password==null||password.length()<5||password.length()>10){
                return CommonResult.failed("密码长度：8~20");
            }

            String nickname = user.getNickname();
            if (nickname!=null){
                int length = 0;
                 for (int i = 0; i < nickname.length(); i++) {
                     int ascii = Character.codePointAt(nickname, i);
                    if (ascii >= 0 && ascii <= 255) {
                        length++;
                    } else {
                        length += 2;
                    }
                 }

                 if (length>16){
                     return CommonResult.failed("昵称长度为16个之母或8个汉字");
                 }else if (length<4){
                     return CommonResult.failed("昵称长度为4个之母或两个汉字");
                 }
            }
        }
        try{
            Boolean addTrue = userService.insertUser(user);
            if (addTrue){
                return CommonResult.success("注册成功");
            }else{
                return CommonResult.failed("注册失败");
            }
        }catch (Exception e){
            return CommonResult.failed("用户名已经存在");
        }


    }


    @GetMapping("pwd")
    public String toUpdatePwd(Model model){
        model.addAttribute("user",authDetails.getUser());
        return "password";
    }

    @PostMapping("pwd")
    @ResponseBody
    public CommonResult updatePassword(@RequestBody JSONObject jsonObject){


        String username = jsonObject.getString("username");
        String passwordOld =jsonObject.getString("passwordOld");
        String passwordNew = jsonObject.getString("passwordNew");


        User user = userService.selectUserByName(username);

        if (user==null){
            return CommonResult.failed("用户不存在");
        }

        if (!new BCryptPasswordEncoder().matches(passwordOld,user.getPassword())){
            return CommonResult.failed("密码不正确");
        }

        if (StrUtil.isBlank(passwordNew)||passwordNew.length()<5||passwordNew.length()>10){
            return CommonResult.failed("密码长度：8~20");
        }


        user.setPassword(new BCryptPasswordEncoder().encode(passwordNew));

        Boolean bol = userService.updateUserPassword(user);

        if (bol){
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }

}
