package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.gateway.entity.LoginUser;
import net.ttcxy.tang.gateway.entity.param.RegisterParam;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.UserService;
import net.ttcxy.tang.gateway.service.impl.FansServiceImpl;
import net.ttcxy.tang.model.User;
import net.ttcxy.tang.gateway.security.MySecurityData;
import net.ttcxy.tang.util.StringProUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户相关操作
 * created by huanglei on 2020/10/10
 */
@RestController
public class UserController {

    @Autowired
    private FansServiceImpl fansService;

    @Autowired
    private AuthDetailsService authDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping(value = "user/info")
    public CommonResult<Integer> updateUser(@RequestBody LoginUser loginUser){
        String id = authDetailsService.getUser().getId();
        String nickname = loginUser.getNickname();

        ReUtil.contains("dfsdfsd","");

        if (StrUtil.isNotBlank(nickname)){
            int length = StringProUtil.byteSize(nickname);
            if (length > 16 || length < 4){
                return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
            }
        }else{
            return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        String signature = loginUser.getSignature();
        if (StrUtil.isNotBlank(signature)){
            int length = StringProUtil.byteSize(signature);
            if (length > 50){
                return CommonResult.failed("签名长度为50个之母或25个汉字");
            }
        }
        loginUser.setId(id);

        User user = new User();
        BeanUtil.copyProperties(loginUser,user);
        int count = userService.updateUser(user);
        if (count > 0){
            LoginUser uu = authDetailsService.getUser();
            uu.setNickname(nickname);
            uu.setSignature(signature);
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 关注用户
     */
    @GetMapping("user/fans")
    public CommonResult<List<LoginUser>> fans(){
        String userId = authDetailsService.getUser().getId();
        List<LoginUser> fansList = fansService.selectFansList(userId);
        return CommonResult.success(fansList);
    }


    /**
     * User列表
     * @param page 页码
     * @return List<User>
     */
    @PostMapping("list")
    public CommonResult<List<User>> listUser(@RequestParam(defaultValue = "1") Integer page){
        return CommonResult.success(userService.listUser(page));
    }

    /**
     * 注册请求
     * @param register register
     * @return 状态
     */
    @PostMapping("register")
    public CommonResult<String> register(@RequestBody RegisterParam register){



        if (register == null){
            return CommonResult.failed("参数不正确");
        }else{
            String password = register.getPassword();
            String passwordRe = "(?=.*?[a-z])(?=.*?[0-9]){8,25}";
            if(ReUtil.contains(passwordRe,password)){
                RegisterParam registerParam = (RegisterParam)httpSession.getAttribute(MySecurityData.REG_VERIFY_DATA);
                String mail = registerParam.getMail();

                Boolean aBoolean = userService.selectMailIsTrue(mail);
                if (aBoolean){
                    return CommonResult.failed("邮箱以存在");
                }

                User user = new User();
                user.setPassword(password);
                user.setMail(mail);
                String username = getUsername();
                user.setNickname(username);
                user.setUsername(username);

                user.setId(IdUtil.fastSimpleUUID());

                int i = userService.insertUser(user);
                if (i > 0){
                    return CommonResult.success("注册成功");
                }
            }else{
                return CommonResult.failed();
            }

        }
        return null;

    }

    /**
     * 密码修改
     * @param register register
     * @return 修改状态
     */
    @PostMapping("password")
    public CommonResult<String> updatePassword(@RequestBody RegisterParam register){
        if (register == null){
            return CommonResult.failed("参数不正确");
        }else{
            String password = register.getPassword();
            String passwordRe = "(?=.*?[a-z])(?=.*?[0-9]){8,25}";
            if(ReUtil.contains(passwordRe,password)){
                RegisterParam registerParam = (RegisterParam)httpSession.getAttribute(MySecurityData.REG_VERIFY_DATA);
                if (registerParam == null){
                    return CommonResult.failed("没有收到验证码");
                }
                String mail = registerParam.getMail();

                LoginUser user = userService.selectLoginUserByMail(mail);
                if (user == null){
                    return CommonResult.failed("邮箱未注册");
                }
                User updateUser = new User();
                updateUser.setId(user.getId());
                updateUser.setPassword(new BCryptPasswordEncoder().encode(password));
                int i = userService.updateUserPassword(updateUser);
                if (i > 0){
                    return CommonResult.success("密码更新成功");
                }
            }else{
                return CommonResult.failed();
            }

        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(ReUtil.contains("(?=.*?[a-z])(?=.*?[0-9]){8,25}","o1rd"));
    }

    private String getUsername(){
        while(true){
            String name = "t" + RandomUtil.randomNumbers(9);
            Boolean isUsername = userService.selectUsernameIsTrue(name);
            Boolean isNickname = userService.selectNicknameIsTrue(name);
            if (!isUsername && !isNickname){
                return name;
            }
        }
    }
}
