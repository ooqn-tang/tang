package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.entity.dto.UtsLoginDto;
import net.ttcxy.tang.entity.model.UtsAuthor;
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
    public UtsAuthor getAuthor(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            authentication.getDetails();
            UtsLoginDto principal = (UtsLoginDto) authentication.getPrincipal();
            return principal.getAuthor();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getAuthorId(){
        UtsAuthor author = getAuthor();
        if (ObjectUtil.isNotNull(author)){
            return author.getAuthorId();
        }
        return "";
    }
}
