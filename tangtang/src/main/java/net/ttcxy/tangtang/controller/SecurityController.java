package net.ttcxy.tangtang.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.model.User;
import net.ttcxy.tangtang.properties.TangTangProperties;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.util.StringProUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆，注册，更改密码
 * @author huanglei
 */
@Controller
public class SecurityController {

    @Autowired
    private TangTangProperties tangTangProperties;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private final static String REQUEST_WITH = "X-Requested-With";

    /**
     * 未登陆控制器
     * @param request request
     * @param response response
     * @return X-Requested-With 请求返回
     * @throws IOException IO
     */
    @GetMapping("/login/require")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.FOUND)
    public CommonResult loginRequire(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!response.getHeaderNames().contains(REQUEST_WITH)){
            redirectStrategy.sendRedirect(request,response,tangTangProperties.getSecurity().getLoginPagePath());
        }
        return CommonResult.success("未登陆");
    }

    /**
     * 注册页面
     */
    @GetMapping("register")
    public ModelAndView toRegister(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    public CommonResult register(@RequestBody User user){


        if (user == null){
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
            if (password==null||password.length()<=8||password.length()>=25){
                return CommonResult.failed("密码长度：8~25");
            }

            String nickname = user.getNickname();
            if (nickname!=null){
                int length = StringProUtil.byteSize(nickname);
                if (length>16 || length<4){
                    return CommonResult.failed("昵称长度为16个之母或8个汉字");
                }
            }
        }
        try{
            int count = userService.insertUser(user);
            if (count > 0){
                return CommonResult.success("注册成功");
            }else{
                return CommonResult.failed("注册失败");
            }
        }catch (DuplicateKeyException e){
            return CommonResult.failed("用户名已经存在");
        }


    }




    @PostMapping("password")
    @ResponseBody
    public CommonResult updatePassword(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String passwordOld =jsonObject.getString("passwordOld");
        String passwordNew = jsonObject.getString("passwordNew");
        UserDto userDto = userService.selectUserByName(username);
        if (userDto ==null){
            return CommonResult.failed("用户不存在");
        }
        if (!new BCryptPasswordEncoder().matches(passwordOld, userDto.getPassword())){
            return CommonResult.failed("密码不正确");
        }
        if (StrUtil.isBlank(passwordNew)||passwordNew.length()<=8||passwordNew.length()>=25){
            return CommonResult.failed("密码长度：8~25");
        }
        userDto.setPassword(new BCryptPasswordEncoder().encode(passwordNew));

        User user = new User();
        BeanUtil.copyProperties(userDto,user);
        int count = userService.updateUserPassword(user);
        if (count > 0){
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("修改失败");
    }
}
