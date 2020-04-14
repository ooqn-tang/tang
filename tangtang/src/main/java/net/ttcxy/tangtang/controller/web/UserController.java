package net.ttcxy.tangtang.controller.web;

import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.entity.dto.User;
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

    /**
     * 用户home页
     * @param username username
     * @param model model
     * @return 结果
     */
    @GetMapping("us/{username}")
    public String toUserHome(@PathVariable("username")String username, Model model){
        model.addAttribute("user",userService.selectUserByName(username));
        return "page/userhome";
    }

    @GetMapping("updateUser")
    public String updateUser(Model model){
        model.addAttribute("user",authDetails.getUser());
        return "updateUser";
    }

    /*@GetMapping("updatePwd")
    public String toUpdatePwd(Model model){
        model.addAttribute("user",authDetails.getUser());
        return "updatePwd";
    }

    @PostMapping("updatePwd")
    @ResponseBody
    public ResponseData updatePassword(@RequestBody User user){

        User authUser = authDetails.getUser();
        user.setId(authUser.getId());
        userService.updateUserPassword(user);
        return ResponseData.successful("");
    }*/

    @Autowired
    FansServiceImpl fansService;

    @GetMapping("user/gz")
    @ResponseBody
    public ResponseData gz(){

        String userId = authDetails.getUser().getId();
        List<User> fansList = fansService.selectFansList(userId);
        return ResponseData.successful(fansList);
    }

    @Autowired
    private AuthDetailsImpl authDetails;

    @PostMapping("updateuser")
    @ResponseBody
    public ResponseData updateUser(@RequestBody User user){
        String id = authDetails.getUser().getId();
        user.setId(id);
        int yesNo = userService.updateUser(user);
        return ResponseData.successful(yesNo);
    }

    @GetMapping("register")
    public String toRegister(){
        return "register";
    }

    /**
     * 注册页面
     * @return register
     */
    @GetMapping("register.html")
    public String register(){
        return "register";

    }

    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    public ResponseData register(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("mail") String mail){

        userService.insertUser(username,password,mail);

        return ResponseData.successful("OK");
    }



    //退出

    //点赞

    //评论

    //收藏

    //举报

}
