package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tang.entity.dto.MailVerifyDto;
import net.ttcxy.tang.service.MailVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static net.ttcxy.tang.core.ApplicationGlobal.MAIL_VERIFY;

@Service
public class MailVerifyServiceImpl implements MailVerifyService {

    @Value("${mail.user}")
    private String mailUser;

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.pass}")
    private String mailPass;

    @Value("${mail.port}")
    private Integer mailPort;

    @Value("${mail.host}")
    private String mailHost;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void sendMailVerify(String mail) {
        MailAccount mailAccount = new MailAccount();
        mailAccount.setFrom(mailFrom);
        mailAccount.setUser(mailUser);
        mailAccount.setPass(mailPass);
        mailAccount.setPort(mailPort);
        mailAccount.setHost(mailHost);
        String code = RandomUtil.randomNumbers(4);

        MailVerifyDto mailVerifyDto = new MailVerifyDto(mail,code);
        httpSession.setAttribute(MAIL_VERIFY,mailVerifyDto);

        MailUtil.send(mailAccount,mail,"验证码：" + code,"系统消息。",false);
    }
}
