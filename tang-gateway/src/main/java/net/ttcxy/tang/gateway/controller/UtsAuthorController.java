package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.entity.param.UtsAuthorParam;
import net.ttcxy.tang.gateway.entity.param.UtsRegisterParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.gateway.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户相关操作
 * @author huanglei
 */
@RestController
@RequestMapping("author")
@Api("作者创作类")
public class UtsAuthorController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsAuthorService authorService;

    @PostMapping(value = "update")
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody UtsAuthorParam utsAuthorParam){
        String authorId = currentAuthorService.getAuthor().getAuthorId();
        String nickname = utsAuthorParam.getNickname();
        // 获取昵称字节长度
        int length = TextUtil.byteSize(nickname);
        if (StrUtil.isNotBlank(nickname) && (length > 16 || length < 4)){
            throw new ApiException(ResponseCode.FAILED.getCode(),"昵称长度：汉字 2 ~ 8,字母 4 ~ 16");
        }

        UtsAuthor author = new UtsAuthor();

        BeanUtil.copyProperties(utsAuthorParam, author);

        author.setAuthorId(authorId);

        int count = authorService.updateAuthor(author);
        if (count > 0){
            UtsAuthor currentAuthor = currentAuthorService.getAuthor();
            currentAuthor.setNickname(utsAuthorParam.getNickname());
            currentAuthor.setSignature(utsAuthorParam.getSignature());
            return ResponseResult.success("更新成功");
        }
        throw new ApiException();
    }

    @PostMapping("register")
    @ApiOperation("注册请求")
    public ResponseResult<?> register(@RequestBody UtsRegisterParam register){

        String mail = register.getMail();
        Boolean aBoolean = authorService.selectMailIsTrue(mail);
        if (aBoolean){
            throw new ApiException("邮箱以存在");
        }

        String password = register.getPassword();

        UtsAuthor author = new UtsAuthor();
        author.setPassword(new BCryptPasswordEncoder().encode(password));
        author.setMail(mail);

        int count = authorService.insertAuthor(author);
        if (count > 0){
             return ResponseResult.success();
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PostMapping("password")
    @ApiOperation("密码修改")
    public ResponseResult<?> updatePassword(@RequestBody UtsRegisterParam register){

        String mail = register.getMail();
        String password = register.getPassword();

        if (authorService.selectAuthorByMail(mail) == null){
            throw new ApiException("邮箱未注册");
        }

        String authorId = currentAuthorService.getAuthorId();
        UtsAuthor author = new UtsAuthor();
        author.setAuthorId(authorId);
        author.setPassword(new BCryptPasswordEncoder().encode(password));

        int count = authorService.updateAuthor(author);
        if (count > 0){
            return ResponseResult.success();
        }

        throw new ApiException();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mima135654.."));
    }
}
