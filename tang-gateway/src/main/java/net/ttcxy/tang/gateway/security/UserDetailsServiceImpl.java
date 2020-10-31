package net.ttcxy.tang.gateway.security;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.gateway.entity.LoginUser;
import net.ttcxy.tang.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser loginUser = null;
        if (Validator.isEmail(username)){
            loginUser = userService.selectLoginUserByMail(username);
        }else{
            loginUser = userService.selectUserByName(username);
        }
        if (loginUser ==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return loginUser;
    }
}
