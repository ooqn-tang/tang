package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.dto.MailVerifyDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorUpdateParam;
import net.ttcxy.tang.portal.entity.param.UtsRePasswordParam;
import net.ttcxy.tang.portal.entity.param.UtsRegisterParam;
import net.ttcxy.tang.portal.service.CurrentAuthorService;
import net.ttcxy.tang.portal.service.MailVerifyService;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;

import static net.ttcxy.tang.portal.core.ApplicationGlobal.MAIL_VERIFY;

@RestController
@RequestMapping("api/author")
@Api("作者创作类")
@Validated
public class ApiAuthorController {


    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private MailVerifyService mailVerifyService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("isLogin")
    public ResponseResult<Boolean> isLogin(){
        UtsAuthor author = currentAuthorService.getAuthor();
        if (author == null){
            return ResponseResult.success(false);
        }
        return ResponseResult.success(true);
    }

    @PutMapping
    @ApiOperation("更新作者")
    public ResponseResult<?> updateAuthor(@RequestBody UtsAuthorUpdateParam authorParam){

        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);

        String authorId = currentAuthorService.getAuthor().getAuthorId();

        author.setAuthorId(authorId);

        int count = authorService.updateAuthorByName(author);
        if (count > 0){
            UtsAuthor currentAuthor = currentAuthorService.getAuthor();
            currentAuthor = authorService.selectAuthorByName(currentAuthor.getUsername());
            return ResponseResult.success("更新成功");
        }
        throw new ApiException();
    }

    @PostMapping
    @ApiOperation("注册请求")
    public ResponseResult<?> register(@RequestBody UtsRegisterParam register){

        String mail = register.getMail();
        Boolean isTrue = authorService.selectMailIsTrue(mail);
        if (isTrue){
            throw new ApiException("邮箱以存在");
        }

        MailVerifyDto mailVerifyDto = (MailVerifyDto)httpSession.getAttribute(MAIL_VERIFY);

        if (mailVerifyDto == null){
            throw new ApiException("请输入验证码");
        }

        if (StrUtil.equals(mailVerifyDto.getMail(),register.getMail())){
            if (StrUtil.equals(mailVerifyDto.getCode(),register.getCode())){
                UtsAuthor author = BeanUtil.toBean(register, UtsAuthor.class);
                String password = register.getPassword();
                author.setPassword(new BCryptPasswordEncoder().encode(password));
                author.setMail(mail);

                int count = authorService.insertAuthor(author);
                if (count > 0){
                    return ResponseResult.success("修改成功");
                }
            }
        }

        throw new ApiException(ResponseCode.FAILED);
    }

    @PostMapping("password")
    @ApiOperation("密码修改")
    public ResponseResult<?> updatePassword(@RequestBody UtsRePasswordParam param){

        String mail = param.getMail();
        Boolean isTrue = authorService.selectMailIsTrue(mail);
        if (!isTrue){
            throw new ApiException("邮箱不存在");
        }

        MailVerifyDto mailVerifyDto = (MailVerifyDto)httpSession.getAttribute(MAIL_VERIFY);

        if (mailVerifyDto == null){
            throw new ApiException("请输入验证码");
        }

        if (StrUtil.equals(mailVerifyDto.getMail(), param.getMail())){
            if (StrUtil.equals(mailVerifyDto.getCode(), param.getCode())){
                String password = param.getPassword();
                UtsAuthor author = BeanUtil.toBean(param, UtsAuthor.class);
                author.setPassword(new BCryptPasswordEncoder().encode(password));

                int count = authorService.updateAuthorByName(author);
                if (count > 0){
                    return ResponseResult.success("处理成功");
                }
            }
        }



        throw new ApiException();
    }

    @GetMapping("{username}")
    @ApiOperation("获取用户信息")
    public ResponseResult<UtsAuthor> authorByUsername(@PathVariable(value = "username") String username){
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        utsAuthor.setPassword(null);
        return ResponseResult.success(utsAuthor);
    }

    @GetMapping("list")
    @ApiOperation("作者列表")
    public ResponseResult<PageInfo<UtsAuthor>> authorList(@RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseResult.success(authorService.authorList(page,10));
    }



    @PostMapping("mail-verify")
    @ApiOperation("发送验证码")
    public ResponseResult<?> sendMailVerify(@RequestParam("mail") @Email(message = "请输入正确邮箱号") String mail){
        mailVerifyService.sendMailVerify(mail);
        return ResponseResult.success("处理成功");
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mima135654.."));
    }
}
