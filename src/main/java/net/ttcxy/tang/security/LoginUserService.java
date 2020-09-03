package net.ttcxy.tang.security;


import net.ttcxy.tang.entity.LoginUser;
import net.ttcxy.tang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * created by huanglei on 2020/09/01
 */
@Component("userDetailsService")
public class LoginUserService implements UserDetailsService {

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = userServiceImpl.selectUserByName(username);
        if (loginUser ==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return loginUser;
    }
}
