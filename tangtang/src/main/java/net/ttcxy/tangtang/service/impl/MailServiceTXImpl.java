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
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("17674785177@163.com");
        account.setUser("17674785177");
        account.setPass("QIMFZXBWRYJEZJPM");

        MailUtil.send(account, CollUtil.newArrayList(mail), title, val, false);

        return false;
    }

    public static void main(String[] args) {
        MailServiceTXImpl mst = new MailServiceTXImpl();
        mst.send("792190997@qq.com","asdfasdf","dsajfkjdkfj");
    }

}
