package net.ttcxy.tang.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.db.dao.UtsRoleDao;
import net.ttcxy.tang.entity.UtsAuthorLogin;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private UtsRoleDao utsRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UtsAuthorLogin author = null;
        if (Validator.isEmail(username)){
            author = authorService.selectLoginAuthorByMail(username);
        }else{
            author = authorService.selectUserByName(username);
        }
        if (author == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String authorId = author.getId();
        List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByAuthorId(authorId);
        author.setRoleDtoList(utsRoleDtoList);

        return author;
    }


}
