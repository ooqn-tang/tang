package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.service.SmsService;

/**
 * 阿里验证码实现
 * @author huanglei
 */
public class SmsServiceAliImpl implements SmsService {

    @Override
    public boolean sendCode(String sms, String code) {
        return false;
    }
}
