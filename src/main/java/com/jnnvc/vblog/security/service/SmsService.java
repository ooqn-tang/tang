package com.jnnvc.vblog.security.service;

import org.springframework.stereotype.Service;

public interface SmsService {

    /**
     * 发送手机验证码
     * @return
     */
    Boolean sendCode(String sms,String code);
}
