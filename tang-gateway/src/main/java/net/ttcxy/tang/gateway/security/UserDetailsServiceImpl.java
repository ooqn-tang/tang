package net.ttcxy.tang.gateway.security;


import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private AuthorService authorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AuthorLogin author = null;
        if (Validator.isEmail(username)){
            author = authorService.selectLoginUserByMail(username);
        }else{
            author = authorService.selectUserByName(username);
        }
        if (author ==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return author;
    }


}
