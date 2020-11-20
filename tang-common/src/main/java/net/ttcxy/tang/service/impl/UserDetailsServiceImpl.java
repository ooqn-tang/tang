package net.ttcxy.tang.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.db.dao.UtsRoleDao;
import net.ttcxy.tang.entity.UtsAuthorLogin;
import net.ttcxy.tang.entity.dto.UtsAuthorDto;
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
    private UtsAuthorService utsAuthorService;

    @Autowired
    private UtsRoleDao utsRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UtsAuthorLogin utsAuthorLogin = null;

        if (Validator.isEmail(username)){
            utsAuthorLogin = utsAuthorService.selectLoginAuthorByMail(username);
        }else{
            utsAuthorLogin = utsAuthorService.selectUserByName(username);
        }
        if (utsAuthorLogin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String authorId = utsAuthorLogin.getId();
        List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByAuthorId(authorId);
        utsAuthorLogin.setRoleDtoList(utsRoleDtoList);

        return utsAuthorLogin;
    }


}
