package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.service.StsSmsService;

/**
 * 阿里验证码服务
 * @author huanglei
 */
public class StsSmsServiceTencentImpl implements StsSmsService {

    @Override
    public boolean sendCode(String sms, String code) {
        return false;
    }
}
