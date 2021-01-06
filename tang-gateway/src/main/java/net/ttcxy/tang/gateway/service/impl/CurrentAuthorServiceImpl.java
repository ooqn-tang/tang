package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
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
    public UtsAuthorLogin getAuthor(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            authentication.getDetails();
            return (UtsAuthorLogin)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getAuthorId(){
        UtsAuthorLogin author = getAuthor();
        if (ObjectUtil.isNotNull(author)){
            return author.getId();
        }
        return "";
    }
}
