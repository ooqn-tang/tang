package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.MySecurityData;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.gateway.entity.param.UtsAuthorParam;
import net.ttcxy.tang.gateway.entity.param.UtsRegisterParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
@RequestMapping("author")
@Api("作者创作类")
public class UtsAuthorController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsAuthorService authorService;

    @PostMapping(value = "update")
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody @Valid UtsAuthorParam utsAuthorParam){
        String id = currentAuthorService.getAuthor().getId();
        String nickname = utsAuthorParam.getNickname();
        int length = TextUtil.byteSize(nickname);
        if (StrUtil.isNotBlank(nickname) && (length > 16 || length < 4)){
            return ResponseResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        UtsAuthor author = new UtsAuthor();
        BeanUtil.copyProperties(utsAuthorParam, author);

        author.setId(id);
        int count = authorService.updateAuthor(author);
        if (count > 0){
            UtsAuthorLogin utsAuthorLogin = currentAuthorService.getAuthor();
            utsAuthorLogin.setNickname(utsAuthorParam.getNickname());
            utsAuthorLogin.setSignature(utsAuthorParam.getSignature());
            return ResponseResult.success("更新成功");
        }
        return ResponseResult.failed();
    }

    @PostMapping("list")
    @ApiOperation("author列表")
    public ResponseResult<?> listAuthor(@RequestParam(defaultValue = "1") Integer page){
        return ResponseResult.success(authorService.authorList(page));
    }

    @PostMapping("register")
    @ApiOperation("注册请求")
    public ResponseResult<?> register(@RequestBody @Valid @NotNull(message = "参数不能为空") UtsRegisterParam register){
        if (!verify(register.getVerify())){
            return ResponseResult.validateFailed("验证码不正确");
        }

        String mail = register.getMail();
        Boolean aBoolean = authorService.selectMailIsTrue(mail);
        if (aBoolean){
            return ResponseResult.failed("邮箱以存在");
        }

        String password = register.getPassword();
        String username = getUsername();
        UtsAuthor author = new UtsAuthor();
        author.setId(IdUtil.fastSimpleUUID());
        author.setPassword(new BCryptPasswordEncoder().encode(password));
        author.setMail(mail);
        author.setNickname(username);
        author.setUsername(username);

        int count = authorService.insertAuthor(author);
        if (count > 0){
             return ResponseResult.success("注册成功");
        }
        return ResponseResult.failed();
    }

    @PostMapping("password")
    @ApiOperation("密码修改")
    public ResponseResult<?> updatePassword(@RequestBody @Valid @NotNull(message = "参数不能为空") UtsRegisterParam register){
        if (!verify(register.getVerify())){
            return ResponseResult.validateFailed("验证码不正确");
        }

        String mail = register.getMail();
        String password = register.getPassword();

        UtsAuthorLogin utsAuthorLogin = authorService.selectAuthorByMail(mail);
        if (utsAuthorLogin == null){
            return ResponseResult.failed("邮箱未注册");
        }

        UtsAuthor author = new UtsAuthor();
        author.setId(utsAuthorLogin.getId());
        author.setPassword(new BCryptPasswordEncoder().encode(password));

        int count = authorService.updateAuthor(author);
        if (count > 0){
            return ResponseResult.success("密码更新成功");
        }

        return ResponseResult.failed();
    }

    /**
     * 生成用户名
     */
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

    @Autowired
    private HttpSession httpSession;

    private Boolean verify(String code){
        String attribute = (String) httpSession.getAttribute(MySecurityData.MAIL_VERIFY_CODE);
        httpSession.removeAttribute(MySecurityData.MAIL_VERIFY_CODE);
        return StrUtil.equals(code, attribute);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mima135654.."));
    }
}
