package com.ooqn.util;

import cn.hutool.crypto.digest.BCrypt;

/**
 * 制作数据库密码
 */
public class Password {

	public static void main(String[] args) {
		System.out.println(BCrypt.hashpw("123456789"));
	}
}
