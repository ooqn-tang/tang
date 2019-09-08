package com.jnnvc.vblog.entity;

import lombok.Data;

/**
 * 用户
 */
@Data
public class User {

    //用户id
    private String id;

    //用户名
    private String username;

    //密码
    private String password;

    //头像
    private String headPortrait;

    //签名
    private String signature;

    //生日
    private String birthday;

    //性别
    private String sex;

    //城市
    private String city;

    //职位
    private String position;

}
