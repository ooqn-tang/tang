package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.model.UtsMember;
import net.ttcxy.tang.gateway.entity.param.UtsAuthorParam;
import net.ttcxy.tang.gateway.entity.param.UtsRegisterParam;
import net.ttcxy.tang.gateway.service.CurrentMemberService;
import net.ttcxy.tang.gateway.service.UtsMemberService;
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
public class UtsMemberController {

    @Autowired
    private CurrentMemberService currentMemberService;

    @Autowired
    private UtsMemberService authorService;

    @PostMapping(value = "update")
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody @Valid UtsAuthorParam utsAuthorParam){
        String id = currentMemberService.getMember().getId();
        String nickname = utsAuthorParam.getNickname();
        int length = TextUtil.byteSize(nickname);
        if (StrUtil.isNotBlank(nickname) && (length > 16 || length < 4)){
            return ResponseResult.failed("昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        UtsMember author = new UtsMember();
        BeanUtil.copyProperties(utsAuthorParam, author);

        author.setId(id);
        int count = authorService.updateMember(author);
        if (count > 0){
            UtsMemberLogin utsMemberLogin = currentMemberService.getMember();
            utsMemberLogin.setNickname(utsAuthorParam.getNickname());
            utsMemberLogin.setSignature(utsAuthorParam.getSignature());
            return ResponseResult.success("更新成功");
        }
        return ResponseResult.failed();
    }

    @PostMapping("list")
    @ApiOperation("author列表")
    public ResponseResult<?> listAuthor(@RequestParam(defaultValue = "1") Integer page){
        return ResponseResult.success(authorService.memberList(page));
    }

    @PostMapping("register")
    @ApiOperation("注册请求")
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

        int count = authorService.insertMember(author);
        if (count > 0){
            return ResponseResult.success("注册成功");
        }

        return null;

    }

    @PostMapping("password")
    @ApiOperation("密码修改")
    public ResponseResult<?> updatePassword(@RequestBody @Valid @NotNull(message = "参数不能为空") UtsRegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        UtsMemberLogin utsMemberLogin = authorService.selectMemberByMail(mail);
        if (utsMemberLogin == null){
            return ResponseResult.failed("邮箱未注册");
        }

        UtsMember member = new UtsMember();
        member.setId(utsMemberLogin.getId());
        member.setPassword(new BCryptPasswordEncoder().encode(password));

        int count = authorService.updateMember(member);
        if (count > 0){
            return ResponseResult.success("密码更新成功");
        }

        return null;
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
}
