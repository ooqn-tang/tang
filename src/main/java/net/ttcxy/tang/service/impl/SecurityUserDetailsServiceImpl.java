package net.ttcxy.tang.service.impl;


import net.ttcxy.tang.entity.UserDto;
import net.ttcxy.tang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@Component("UserDetailsService")
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userServiceImpl.selectUserByName(username);
        if (userDto ==null){
            logger.info("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }
        return userDto;
    }
}
