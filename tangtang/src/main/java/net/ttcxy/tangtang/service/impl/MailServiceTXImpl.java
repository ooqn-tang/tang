package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import net.ttcxy.tangtang.security.properties.SecurityProperties;
import net.ttcxy.tangtang.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：HuangLei
 * @date ：2019/11/26 0026 20:21
 */
@Service
public class MailServiceTXImpl implements MailService {

    @Autowired
    SecurityProperties securityProperties;



    @Override
    public boolean send(String mail,String title,String val) {

        MailAccount account = new MailAccount();
        account.setHost(securityProperties.getOther().getHost());
        account.setPort(securityProperties.getOther().getPort());
        account.setAuth(securityProperties.getOther().getAuth());
        account.setFrom(securityProperties.getOther().getFrom());
        account.setUser(securityProperties.getOther().getUser());
        account.setPass(securityProperties.getOther().getPass());

        MailUtil.send(account, CollUtil.newArrayList(mail), title, val, false);

        return false;
    }

    public static void main(String[] args) {
        MailServiceTXImpl mst = new MailServiceTXImpl();
        mst.send("792190997@qq.com","asdfasdf","dsajfkjdkfj");
    }

}
