package net.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.entity.UserDto;
import net.ttcxy.model.User;
import net.ttcxy.api.CommonResult;
import net.ttcxy.service.UserService;
import net.ttcxy.util.StringProUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 登陆，注册，更改密码
 * @author huanglei
 */
@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    /**
     * 注册页面
     */
    @GetMapping("register")
    public ModelAndView toRegister(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    /**
     * 注册请求
     * @param user user
     * @return 状态
     */
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

    /**
     * 密码修改
     * @param mapBody mapBody
     * @return 修改状态
     */
    @PostMapping("password")
    @ResponseBody
    public CommonResult updatePassword(@RequestBody Map<String,String> mapBody){
        String username = mapBody.get("username");
        String passwordOld = mapBody.get("passwordOld");
        String passwordNew = mapBody.get("passwordNew");
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
