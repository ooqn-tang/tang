package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.service.CurrentAuthorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 获取当前用户消息
 * @author huanglei
 */
@Service
public class CurrentAuthorServiceImpl implements CurrentAuthorService {

    @Override
    public UtsMemberLogin getAuthor(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (UtsMemberLogin)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getAuthorId(){
        UtsMemberLogin author = getAuthor();
        if (ObjectUtil.isNotNull(author)){
            return author.getId();
        }
        return "";
    }
}
