package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.param.RegisterParam;
import net.ttcxy.tang.gateway.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.FansService;
import net.ttcxy.tang.gateway.service.AuthorService;
import net.ttcxy.tang.gateway.security.MySecurityData;
import net.ttcxy.tang.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
public class UserController {

    @Autowired
    private FansService fansService;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping(value = "user/info")
    public CommonResult<Integer> updateUser(@RequestBody AuthorLogin loginAuthor){
        String id = currentAuthorService.getUser().getId();
        String nickname = loginAuthor.getNickname();

        ReUtil.contains("dfsdfsd","");

        if (cn.hutool.core.util.StrUtil.isNotBlank(nickname)){
            int length = TextUtil.byteSize(nickname);
            if (length > 16 || length < 4){
                return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
            }
        }else{
            return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        String signature = loginAuthor.getSignature();
        if (cn.hutool.core.util.StrUtil.isNotBlank(signature)){
            int length = TextUtil.byteSize(signature);
            if (length > 50){
                return CommonResult.failed("签名长度为50个之母或25个汉字");
            }
        }
        loginAuthor.setId(id);

        net.ttcxy.tang.model.Author author = new net.ttcxy.tang.model.Author();
        BeanUtil.copyProperties(loginAuthor, author);
        int count = authorService.updateUser(author);
        if (count > 0){
            AuthorLogin uu = currentAuthorService.getUser();
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
    public CommonResult<List<AuthorLogin>> fans(){
        String userId = currentAuthorService.getUser().getId();
        List<AuthorLogin> fansList = fansService.selectFansList(userId);
        return CommonResult.success(fansList);
    }


    /**
     * User列表
     * @param page 页码
     * @return List<User>
     */
    @PostMapping("list")
    public CommonResult<List<net.ttcxy.tang.model.Author>> listUser(@RequestParam(defaultValue = "1") Integer page){
        return CommonResult.success(authorService.listUser(page));
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

                Boolean aBoolean = authorService.selectMailIsTrue(mail);
                if (aBoolean){
                    return CommonResult.failed("邮箱以存在");
                }

                net.ttcxy.tang.model.Author author = new net.ttcxy.tang.model.Author();
                author.setPassword(password);
                author.setMail(mail);
                String username = getUsername();
                author.setNickname(username);
                author.setUsername(username);

                author.setId(IdUtil.fastSimpleUUID());

                int i = authorService.insertUser(author);
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

                AuthorLogin user = authorService.selectLoginUserByMail(mail);
                if (user == null){
                    return CommonResult.failed("邮箱未注册");
                }
                net.ttcxy.tang.model.Author updateAuthor = new net.ttcxy.tang.model.Author();
                updateAuthor.setId(user.getId());
                updateAuthor.setPassword(new BCryptPasswordEncoder().encode(password));
                int i = authorService.updateUserPassword(updateAuthor);
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
            Boolean isUsername = authorService.selectUsernameIsTrue(name);
            Boolean isNickname = authorService.selectNicknameIsTrue(name);
            if (!isUsername && !isNickname){
                return name;
            }
        }
    }
}
