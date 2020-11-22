package net.ttcxy.tang.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.db.dao.UtsRoleDao;
import net.ttcxy.tang.entity.UtsMemberLogin;
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

        UtsMemberLogin utsMemberLogin = null;

        if (Validator.isEmail(username)){
            utsMemberLogin = utsAuthorService.selectLoginAuthorByMail(username);
        }else{
            utsMemberLogin = utsAuthorService.selectUserByName(username);
        }
        if (utsMemberLogin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String authorId = utsMemberLogin.getId();
        List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByAuthorId(authorId);
        utsMemberLogin.setRoleDtoList(utsRoleDtoList);

        return utsMemberLogin;
    }


}
