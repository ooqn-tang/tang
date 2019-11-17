package net.ttcxy.tangtang.security.service.impl;


import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


//Springboot + bootstrap3 + mysql + mybatis

@Component
public class SecurityUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名：{}",userServiceImpl.selectUserByName(username));

        User user = userServiceImpl.selectUserByName(username);

        return user;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }
}
