package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.param.AuthorParam;
import net.ttcxy.tang.gateway.entity.param.RegisterParam;
import net.ttcxy.tang.gateway.service.AuthorService;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
@RequestMapping("author")
@Api("作者创作类")
public class AuthorController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "update")
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody @Valid AuthorParam authorParam){
        String id = currentAuthorService.getAuthor().getId();
        String nickname = authorParam.getNickname();
        int length = TextUtil.byteSize(nickname);
        if (StrUtil.isNotBlank(nickname) && (length > 16 || length < 4)){
            return ResponseResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        UtsAuthor author = new UtsAuthor();
        BeanUtil.copyProperties(authorParam, author);

        author.setId(id);
        int count = authorService.updateAuthor(author);
        if (count > 0){
            AuthorLogin authorLogin = currentAuthorService.getAuthor();
            authorLogin.setNickname(authorParam.getNickname());
            authorLogin.setSignature(authorParam.getSignature());
            return ResponseResult.success("更新成功");
        }
        return ResponseResult.failed();
    }


    /**
     * author列表
     * @param page 页码
     * @return List<author>
     */
    @PostMapping("list")
    public ResponseResult<?> listAuthor(@RequestParam(defaultValue = "1") Integer page){
        return ResponseResult.success(authorService.listAuthor(page));
    }

    /**
     * 注册请求
     * @param register register
     * @return 状态
     */
    @PostMapping("register")
    public ResponseResult<?> register(@RequestBody @Valid @NotNull(message = "参数不能为空") RegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        Boolean aBoolean = authorService.selectMailIsTrue(mail);
        if (aBoolean){
            return ResponseResult.failed("邮箱以存在");
        }

        String username = getUsername();
        UtsAuthor author = new UtsAuthor();
        author.setId(IdUtil.fastSimpleUUID());
        author.setPassword(password);
        author.setMail(mail);
        author.setNickname(username);
        author.setUsername(username);

        int count = authorService.insertAuthor(author);
        if (count > 0){
            return ResponseResult.success("注册成功");
        }

        return null;

    }

    /**
     * 密码修改
     * @param register register
     * @return 修改状态
     */
    @PostMapping("password")
    public ResponseResult<?> updatePassword(@RequestBody @Valid @NotNull(message = "参数不能为空") RegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        AuthorLogin authorLogin = authorService.selectLoginAuthorByMail(mail);
        if (authorLogin == null){
            return ResponseResult.failed("邮箱未注册");
        }

        UtsAuthor author = new UtsAuthor();
        author.setId(authorLogin.getId());
        author.setPassword(new BCryptPasswordEncoder().encode(password));

        int count = authorService.updateAuthorPassword(author);
        if (count > 0){
            return ResponseResult.success("密码更新成功");
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
