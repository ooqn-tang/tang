package net.ttcxy.tang.gateway.code.security;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.gateway.dao.RoleDao;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.RoleDto;
import net.ttcxy.tang.gateway.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AuthorLogin author = null;
        if (Validator.isEmail(username)){
            author = authorService.selectLoginAuthorByMail(username);
        }else{
            author = authorService.selectUserByName(username);
        }
        if (author == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String authorId = author.getId();
        List<RoleDto> roleDtoList = roleDao.selectRoleListByAuthorId(authorId);
        author.setRoleDtoList(roleDtoList);

        return author;
    }


}
