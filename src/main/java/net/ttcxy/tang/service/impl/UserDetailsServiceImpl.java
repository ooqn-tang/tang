package net.ttcxy.tang.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.entity.dto.UtsLoginDto;
import net.ttcxy.tang.entity.model.UtsAuthor;
import net.ttcxy.tang.service.UtsAuthorService;
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
        if (Validator.isEmail(username)){
            UtsAuthor author = utsAuthorService.selectAuthorByMail(username);
            if (author != null){
                UtsLoginDto utsLoginDto = new UtsLoginDto();
                utsLoginDto.setAuthor(author);
                return utsLoginDto;
            }
        }
        throw new UsernameNotFoundException("输入的邮箱号不正确");
    }


}
