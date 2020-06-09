package net.ttcxy.service.impl;

import net.ttcxy.service.SmsService;

/**
 * 阿里验证码实现
 * @author huanglei
 */
public class AliSmsService implements SmsService {

    @Override
    public boolean sendCode(String sms, String code) {
        return false;
    }
}
