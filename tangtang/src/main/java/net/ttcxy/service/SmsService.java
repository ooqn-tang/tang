package net.ttcxy.service;

import org.springframework.stereotype.Service;

public interface SmsService {

    /**
     * 发送手机验证码
     * @param sms 收集号
     * @param code 验证码
     * @return 发送结果
     */
    boolean sendCode(String sms,String code);
}
