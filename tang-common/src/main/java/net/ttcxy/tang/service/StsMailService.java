package net.ttcxy.tang.service;

/**
 * @author huanglei
 */
public interface StsMailService {

    /**
     * 发送邮件
     * @param mail 接收人邮箱
     * @param title 标题
     * @param body 内容
     * @return 是否成功
     */
    boolean sendMail(String mail,String title,String body);

}
