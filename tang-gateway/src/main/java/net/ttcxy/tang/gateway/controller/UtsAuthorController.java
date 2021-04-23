package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.entity.param.UtsAuthorParam;
import net.ttcxy.tang.gateway.entity.param.UtsRegisterParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.gateway.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody UtsAuthorParam authorParam){

        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);

        String authorId = currentAuthorService.getAuthor().getAuthorId();

        author.setAuthorId(authorId);

        int count = authorService.updateAuthor(author);
        if (count > 0){
            UtsAuthor currentAuthor = currentAuthorService.getAuthor();
            currentAuthor.setNickname(authorParam.getNickname());
            currentAuthor.setSignature(authorParam.getSignature());
            return ResponseResult.success("更新成功");
        }
        throw new ApiException();
    }

    @PostMapping
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

    @GetMapping("list")
    @ApiOperation("作者列表")
    public ResponseResult<PageInfo<UtsAuthor>> authorList(@RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseResult.success(authorService.authorList(page,page));
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mima135654.."));
    }
}
