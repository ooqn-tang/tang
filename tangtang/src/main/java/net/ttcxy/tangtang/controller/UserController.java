package net.ttcxy.tangtang.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.model.User;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import net.ttcxy.tangtang.service.impl.FansServiceImpl;
import net.ttcxy.tangtang.util.StringProUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
public class UserController {

    @Autowired
    private FansServiceImpl fansService;

    @Autowired
    private AuthDetailsImpl authDetails;

    @Autowired
    private UserService userService;

    @PostMapping("userinfo")
    @ResponseBody
    public CommonResult updateUser(@RequestBody UserDto userDto){
        String id = authDetails.getUser().getId();
        String nickname = userDto.getNickname();

        ReUtil.contains("dfsdfsd","");

        if (StrUtil.isNotBlank(nickname)){
            int length = StringProUtil.byteSize(nickname);
            if (length > 16 || length<4){
                return CommonResult.failed("昵称长度为16个之母或8个汉字");
            }
        }else{
            return CommonResult.failed("昵称长度为4个之母或两个汉字");
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
            UserDto uu = authDetails.getUser();
            uu.setNickname(nickname);
            uu.setSignature(signature);
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @GetMapping("user/gz")
    @ResponseBody
    public CommonResult gz(){

        String userId = authDetails.getUser().getId();
        List<UserDto> fansList = fansService.selectFansList(userId);
        return CommonResult.success(fansList);
    }


    @PostMapping("list")
    @ResponseBody
    public CommonResult<List<User>> listUser(@RequestParam(defaultValue = "1") Integer page){
        return CommonResult.success(userService.listUser(page));
    }




}
