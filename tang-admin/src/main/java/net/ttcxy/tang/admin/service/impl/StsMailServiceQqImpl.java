package net.ttcxy.tang.admin.service.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tang.admin.service.StsMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author huanglei
 */
@Service
public class StsMailServiceQqImpl implements StsMailService {

    @Value("${mail.from}")
    private String from;
    @Value("${mail.user}")
    private String user;
    @Value("${mail.password}")
    private String password;
    @Override
    public boolean sendMail(String mail, String title, String body) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom(from);
        account.setUser(user);
        account.setPass(password);

        MailUtil.send(account, mail, title, body, false);
        return false;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
