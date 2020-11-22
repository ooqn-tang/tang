package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.param.UtsAuthorParam;
import net.ttcxy.tang.entity.param.UtsRegisterParam;
import net.ttcxy.tang.service.UtsAuthorService;
import net.ttcxy.tang.entity.model.UtsMember;
import net.ttcxy.tang.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

        UtsMember author = new UtsMember();
        BeanUtil.copyProperties(utsAuthorParam, author);

        author.setId(id);
        int count = authorService.updateAuthor(author);
        if (count > 0){
            UtsMemberLogin utsMemberLogin = currentAuthorService.getAuthor();
            utsMemberLogin.setNickname(utsAuthorParam.getNickname());
            utsMemberLogin.setSignature(utsAuthorParam.getSignature());
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
    public ResponseResult<?> register(@RequestBody @Valid @NotNull(message = "参数不能为空") UtsRegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        Boolean aBoolean = authorService.selectMailIsTrue(mail);
        if (aBoolean){
            return ResponseResult.failed("邮箱以存在");
        }

        String username = getUsername();
        UtsMember author = new UtsMember();
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
    public ResponseResult<?> updatePassword(@RequestBody @Valid @NotNull(message = "参数不能为空") UtsRegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        UtsMemberLogin utsMemberLogin = authorService.selectLoginAuthorByMail(mail);
        if (utsMemberLogin == null){
            return ResponseResult.failed("邮箱未注册");
        }

        UtsMember author = new UtsMember();
        author.setId(utsMemberLogin.getId());
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
