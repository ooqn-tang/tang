package net.ttcxy.tang.gateway.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author huanglei
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtsAuthorService utsAuthorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtsAuthorLogin utsAuthorLogin;
        if (Validator.isEmail(username)){
            utsAuthorLogin = utsAuthorService.selectAuthorByMail(username);
        }else{
            utsAuthorLogin = utsAuthorService.selectAuthorByName(username);
        }
        if (utsAuthorLogin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return utsAuthorLogin;
    }


}
