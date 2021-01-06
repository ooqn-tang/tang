package net.ttcxy.tang.gateway.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.MySecurityData;
import net.ttcxy.tang.gateway.entity.param.UtsRegisterParam;
import net.ttcxy.tang.gateway.service.StsMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * 创作者登录相关
 * @author huanglei
 */
@Controller
public class UtsAuthorLoginController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private StsMailService stsMailService;

    @GetMapping("verify")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(128, 32, 4, 20);
        String code = captcha.getCode();
        ServletOutputStream outputStream = null;

        try{
            outputStream = response.getOutputStream();
            captcha.write(outputStream);
        }finally {
            if (outputStream != null){
                outputStream.flush();
            }
        }
        httpSession.setAttribute(MySecurityData.VERIFY_CODE,code);
    }

    @PostMapping("verifyMail/{mail}")
    @ResponseBody
    public ResponseResult<?> sendMailVerify(@PathVariable("mail") String mail){
        try{
            if (!Validator.isEmail(mail)) {
                return ResponseResult.failed("邮箱不正确");
            }
            String code = RandomUtil.randomNumbers(4);
            boolean yes = stsMailService.sendMail(mail, "验证码:" + code, "系统消息无需回复");
            if (yes){
                UtsRegisterParam utsRegisterParam = new UtsRegisterParam();
                utsRegisterParam.setMail(mail);
                utsRegisterParam.setVerify(code);
                httpSession.setAttribute(MySecurityData.MAIL_VERIFY_CODE,code);
                httpSession.setAttribute(MySecurityData.REG_VERIFY_DATA, utsRegisterParam);
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failed();
        }
    }
}
