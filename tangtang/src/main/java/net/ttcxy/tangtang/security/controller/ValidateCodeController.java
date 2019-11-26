package net.ttcxy.tangtang.security.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.RandomUtil;
import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.security.model.ImageValidateCode;
import net.ttcxy.tangtang.security.model.ValidateCode;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
import net.ttcxy.tangtang.service.impl.MailServiceTXImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码
 */
@RestController
public class ValidateCodeController {


    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("code/image.png")
    public void  createCodeImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        ImageValidateCode imageCode = (ImageValidateCode)createImageCode(new ServletWebRequest(httpServletRequest));

        sessionStrategy.setAttribute(new ServletWebRequest(httpServletRequest), SessionKey.SESSION_KEY_IMAGE_CODE, imageCode);
        httpServletResponse.setContentType("image/png");

        ImageIO.write(imageCode.getImage(),"PNG",httpServletResponse.getOutputStream());


    }
    @Autowired
    private MailServiceTXImpl mailServiceTX;

    @GetMapping("code/mail/{mail}")
    public void createCodeMail(@PathVariable String mail, HttpServletRequest httpServletRequest) throws IOException {

        String yzm = RandomUtil.randomString(4);
        ValidateCode validateCode = new ValidateCode(yzm,1000);

        sessionStrategy.setAttribute(new ServletWebRequest(httpServletRequest), SessionKey.SESSION_KEY_MAIL_CODE, validateCode);

        mailServiceTX.send(mail,"验证码",yzm);
    }

    @GetMapping("code/sms")
    public void  createCodeSms(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

    }

    /**
     * 验证码图片
     * @param request
     * @return
     */
    private ValidateCode createImageCode(ServletWebRequest request) {


        int width = ServletRequestUtils.getIntParameter(request.getRequest(),"width",securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",securityProperties.getCode().getImage().getHeight());

        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(width,height,
                securityProperties.getCode().getImage().getLength(),
                securityProperties.getCode().getImage().getDisturb()
        );

        return new ImageValidateCode(lineCaptcha.getImage(),lineCaptcha.getCode(),securityProperties.getCode().getImage().getExpireIn());
    }

    //发送邮箱验证码
    private Boolean sendMail(){
        String randomCode =  RandomUtil.randomString(4);

        return null;
    }
}
