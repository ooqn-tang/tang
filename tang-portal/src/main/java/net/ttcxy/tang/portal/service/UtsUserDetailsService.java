package net.ttcxy.tang.portal.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtsUserDetailsService implements UserDetailsService {

    @Autowired
    private UtsAuthorService utsAuthorService;

    @Autowired
    private UtsRoleService utsRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtsAuthor author;
        if (Validator.isEmail(username)){
            author = utsAuthorService.selectAuthorByMail(username);
        }else{
            author = utsAuthorService.selectAuthorByName(username);
        }

        if (author != null){
            CurrentAuthor currentAuthor = new CurrentAuthor();
            currentAuthor.setUtsAuthor(author);
            List<UtsRole> utsRoles = utsRoleService.selectRoleList(author.getAuthorId());
            currentAuthor.setUtsRoles(utsRoles);
            currentAuthor.setRefreshTime(utsAuthorService.nowTime(author.getUsername(),currentAuthor.getUtsRoles()).getTime());
            return BeanUtil.toBean(currentAuthor,CurrentAuthor.class);
        }


        throw new UsernameNotFoundException("输入的用户名或密码不正确");
    }


}
