package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.service.CurrentMemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 获取当前用户消息
 * @author huanglei
 */
@Service
public class CurrentMemberServiceImpl implements CurrentMemberService {

    @Override
    public UtsMemberLogin getMember(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (UtsMemberLogin)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getMemberId(){
        UtsMemberLogin author = getMember();
        if (ObjectUtil.isNotNull(author)){
            return author.getId();
        }
        return "";
    }
}
