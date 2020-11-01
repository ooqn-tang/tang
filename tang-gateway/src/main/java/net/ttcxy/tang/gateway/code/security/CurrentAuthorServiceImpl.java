package net.ttcxy.tang.gateway.code.security;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
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
    public AuthorLogin getAuthor(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (AuthorLogin)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getAuthorId(){
        AuthorLogin author = getAuthor();
        if (ObjectUtil.isNotNull(author)){
            return author.getId();
        }
        return "";
    }
}
