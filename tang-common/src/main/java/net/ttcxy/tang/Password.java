package net.ttcxy.tang;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 制作数据库密码
 * @author huanglei
 */
public class Password {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456789"));;
    }
}
