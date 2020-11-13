package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tang.gateway.service.MailService;

/**
 * @author huanglei
 */
public class MailServiceQQImpl implements MailService {
    @Override
    public boolean sendMail(String mail, String title, String body) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1604403854@qq.com");
        account.setUser("1604403854@qq.com");
        account.setPass("muijiqqfyyyyhbhc");
//        MailUtil.send(account, mail, "验证码：" + code, "验证码邮件，无需回复。", false);
        MailUtil.send(account, mail, title, body, false);
        return false;
    }
}
