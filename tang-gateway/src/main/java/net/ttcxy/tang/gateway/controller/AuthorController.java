package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.param.RegisterParam;
import net.ttcxy.tang.gateway.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.FansService;
import net.ttcxy.tang.gateway.service.AuthorService;
import net.ttcxy.tang.gateway.security.MySecurityData;
import net.ttcxy.tang.model.Author;
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
@RestController("author")
@Api("作者创作类")
public class AuthorController {

    @Autowired
    private FansService fansService;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping(value = "info")
    @ApiOperation("高兴作者")
    public CommonResult<Integer> updateAuthor(@RequestBody AuthorLogin authorLogin){
        String id = currentAuthorService.getAuthor().getId();
        String nickname = authorLogin.getNickname();

        if (cn.hutool.core.util.StrUtil.isNotBlank(nickname)){
            int length = TextUtil.byteSize(nickname);
            if (length > 16 || length < 4){
                return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
            }
        }else{
            return CommonResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        String signature = authorLogin.getSignature();
        if (cn.hutool.core.util.StrUtil.isNotBlank(signature)){
            int length = TextUtil.byteSize(signature);
            if (length > 50){
                return CommonResult.failed("签名长度为50个之母或25个汉字");
            }
        }
        authorLogin.setId(id);

        Author author = new Author();
        BeanUtil.copyProperties(authorLogin, author);
        int count = authorService.updateAuthor(author);
        if (count > 0){
            AuthorLogin al = currentAuthorService.getAuthor();
            al.setNickname(nickname);
            al.setSignature(signature);
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 关注用户
     */
    @GetMapping("fans")
    public CommonResult<List<AuthorLogin>> fans(){
        String authorId = currentAuthorService.getAuthor().getId();
        List<AuthorLogin> fansList = fansService.selectFansList(authorId);
        return CommonResult.success(fansList);
    }


    /**
     * author列表
     * @param page 页码
     * @return List<author>
     */
    @PostMapping("list")
    public CommonResult<List<Author>> listAuthor(@RequestParam(defaultValue = "1") Integer page){
        return CommonResult.success(authorService.listAuthor(page));
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

                Author author = new Author();
                author.setPassword(password);
                author.setMail(mail);
                String username = getUsername();
                author.setNickname(username);
                author.setUsername(username);

                author.setId(IdUtil.fastSimpleUUID());

                int i = authorService.insertAuthor(author);
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

                AuthorLogin authorLogin = authorService.selectLoginAuthorByMail(mail);
                if (authorLogin == null){
                    return CommonResult.failed("邮箱未注册");
                }
                Author updateAuthor = new Author();
                updateAuthor.setId(authorLogin.getId());
                updateAuthor.setPassword(new BCryptPasswordEncoder().encode(password));
                int i = authorService.updateAuthorPassword(updateAuthor);
                if (i > 0){
                    return CommonResult.success("密码更新成功");
                }
            }else{
                return CommonResult.failed();
            }

        }
        return null;
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
