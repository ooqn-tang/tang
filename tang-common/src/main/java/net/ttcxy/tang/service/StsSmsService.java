package net.ttcxy.tang.service;


/**
 * @author huanglei
 */
public interface StsSmsService {

    /**
     * 发送手机验证码
     * @param sms 收集号
     * @param code 验证码
     * @return 发送结果
     */
    boolean sendCode(String sms,String code);
}
