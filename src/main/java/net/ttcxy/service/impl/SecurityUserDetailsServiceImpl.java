package net.ttcxy.service.impl;


import lombok.extern.slf4j.Slf4j;
import net.ttcxy.entity.UserDto;
import net.ttcxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component
@Slf4j
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userServiceImpl.selectUserByName(username);
        if (userDto ==null){
            log.info("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }
        return userDto;
    }
}
