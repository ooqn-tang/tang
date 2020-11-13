package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tang.gateway.service.StsMailService;
import org.springframework.stereotype.Service;

/**
 * @author huanglei
 */
@Service
public class StsMailServiceQQImpl implements StsMailService {
    @Override
    public boolean sendMail(String mail, String title, String body) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1604403854@qq.com");
        account.setUser("1604403854@qq.com");
        account.setPass("muijiqqfyyyyhbhc");
        MailUtil.send(account, mail, title, body, false);
        return false;
    }
}
