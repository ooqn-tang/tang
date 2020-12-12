package net.ttcxy.tang.gateway.service.impl;


import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.gateway.entity.dto.UtsRoleDto;
import net.ttcxy.tang.gateway.dao.UtsRoleDao;
import net.ttcxy.tang.gateway.service.UtsMemberService;
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
    private UtsMemberService utsMemberService;

    @Autowired
    private UtsRoleDao utsRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UtsMemberLogin utsMemberLogin;

        if (Validator.isEmail(username)){
            utsMemberLogin = utsMemberService.selectMemberByMail(username);
        }else{
            utsMemberLogin = utsMemberService.selectMemberByName(username);
        }
        if (utsMemberLogin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String memberId = utsMemberLogin.getId();
        List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByMemberId(memberId);
        utsMemberLogin.setRoleDtoList(utsRoleDtoList);

        return utsMemberLogin;
    }


}
