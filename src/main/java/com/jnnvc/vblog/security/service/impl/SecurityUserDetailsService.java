package com.jnnvc.vblog.security.service.impl;


import com.jnnvc.vblog.security.model.SessionKey;
import com.jnnvc.vblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SecurityUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("登录用户名：{}",userServiceImpl.selectUserByName(username));

        com.jnnvc.vblog.entity.User u = userServiceImpl.selectUserByName(username);

        session.setAttribute(SessionKey.USER_INFO,u);

        //根据用户名查找用户信息
        User user = new User(username,userServiceImpl.selectUserByName(username).getPassword(),
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return user;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }
}
