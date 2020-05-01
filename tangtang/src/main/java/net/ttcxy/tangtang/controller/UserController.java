package net.ttcxy.tangtang.controller;

import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import net.ttcxy.tangtang.service.impl.FansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关操作
 * @author huanglei
 */
@Controller
public class UserController {



    @GetMapping("userinfo")
    public String updateUser(Model model){
        model.addAttribute("user",authDetails.getUser());
        return "userinfo";
    }
    @PostMapping("userinfo")
    @ResponseBody
    public CommonResult updateUser(@RequestBody User user){
        String id = authDetails.getUser().getId();


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
        }else{
            return CommonResult.failed("昵称长度为4个之母或两个汉字");
        }



        String signature = user.getSignature();




        user.setId(id);
        int yesNo = userService.updateUser(user);
        return CommonResult.success(yesNo);
    }



    @Autowired
    FansServiceImpl fansService;

    @GetMapping("user/gz")
    @ResponseBody
    public CommonResult gz(){

        String userId = authDetails.getUser().getId();
        List<User> fansList = fansService.selectFansList(userId);
        return CommonResult.success(fansList);
    }

    @Autowired
    private AuthDetailsImpl authDetails;


    @Autowired
    private UserService userService;




    //退出

    //点赞

    //评论

    //收藏

    //举报

}
