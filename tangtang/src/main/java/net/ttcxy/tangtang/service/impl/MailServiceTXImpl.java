package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tangtang.service.MailService;
import org.springframework.stereotype.Service;

/**
 * @author ：HuangLei
 * @date ：2019/11/26 0026 20:21
 */
@Service
public class MailServiceTXImpl implements MailService {

    @Override
    public boolean send(String mail,String title,String val) {

        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("792190997@qq.com");
        account.setUser("792190997");
        account.setPass("nvrhhnhdziwibceh");

        MailUtil.send(account, CollUtil.newArrayList(mail), title, val, false);

        return false;
    }

}
