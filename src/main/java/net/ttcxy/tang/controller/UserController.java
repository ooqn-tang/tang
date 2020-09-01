package net.ttcxy.tang.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.entity.UserDto;
import net.ttcxy.tang.model.User;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.service.AuthDetailsService;
import net.ttcxy.tang.service.UserService;
import net.ttcxy.tang.service.impl.FansServiceImpl;
import net.ttcxy.tang.util.StringProUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
public class UserController {

    @Autowired
    private FansServiceImpl fansService;

    @Autowired
    private AuthDetailsService authDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "user/info")
    public CommonResult updateUser(@RequestBody UserDto userDto){
        String id = authDetailsService.getUser().getId();
        String nickname = userDto.getNickname();

        ReUtil.contains("dfsdfsd","");

        if (StrUtil.isNotBlank(nickname)){
            int length = StringProUtil.byteSize(nickname);
            if (length > 16 || length < 4){
                return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
            }
        }else{
            return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        String signature = userDto.getSignature();
        if (StrUtil.isNotBlank(signature)){
            int length = StringProUtil.byteSize(signature);
            if (length > 50){
                return CommonResult.failed("签名长度为50个之母或25个汉字");
            }
        }
        userDto.setId(id);

        User user = new User();
        BeanUtil.copyProperties(userDto,user);
        int count = userService.updateUser(user);
        if (count > 0){
            UserDto uu = authDetailsService.getUser();
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
    public CommonResult<List<UserDto>> fans(){
        String userId = authDetailsService.getUser().getId();
        List<UserDto> fansList = fansService.selectFansList(userId);
        return CommonResult.success(fansList);
    }


    /**
     * User列表
     * @param page 页码
     * @return
     */
    @PostMapping("list")
    public CommonResult<List<User>> listUser(@RequestParam(defaultValue = "1") Integer page){
        return CommonResult.success(userService.listUser(page));
    }

    /**
     * 注册请求
     * @param user user
     * @return 状态
     */
    @PostMapping("register")
    public CommonResult register(@RequestBody User user){

        if (user == null){
            return CommonResult.failed("参数不正确");
        }else{
            String username = user.getUsername();
            if (username==null||username.length() < 2  ||username.length() > 15){
                return CommonResult.failed("用户名长度：2 ~ 15");
            }

            String regex = "^[a-z0-9A-Z]+$";
            if(!username.matches(regex)){
                return CommonResult.failed("用户名必须为数字和字母");
            }

            if (userService.selectUsernameIsTrue(username)){
                return CommonResult.failed("用户名已经存在");
            }

            String password = user.getPassword();
            if (password == null || password.length() < 8 || password.length() > 25){
                return CommonResult.failed("密码长度：8 ~ 25");
            }

            String nickname = user.getNickname();
            if (nickname!=null){
                int length = StringProUtil.byteSize(nickname);
                if (length>16 || length<4){
                    return CommonResult.failed("昵称长度为4 ~ 16个之母或2 ~ 8个汉字");
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
