package net.ttcxy.tangtang.controller;

import cn.hutool.core.util.ReUtil;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import net.ttcxy.tangtang.service.impl.FansServiceImpl;
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
        }else{
            return CommonResult.failed("昵称长度为4个之母或两个汉字");
        }



        String signature = userDto.getSignature();




        userDto.setId(id);
        int yesNo = userService.updateUser(userDto);
        return CommonResult.success(yesNo);
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
    public CommonResult<List<UserDto>> listUser(){
        return CommonResult.success(userService.listUser());
    }

}
