package net.ttcxy.tang.admin.server.impl;

import net.ttcxy.tang.admin.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.admin.server.UtsAuthorServer;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UtsAuthorServerImpl implements UtsAuthorServer {
    @Autowired
    UtsAuthorMapper utsAuthorMapper;
    @Override
    public UtsAuthorDto loadAuthorInfo(String username) {
        UtsAuthorExample utsAuthorExample = new UtsAuthorExample();
        utsAuthorExample.createCriteria().andUsernameEqualTo(username);
        List<UtsAuthor> utsAuthors = utsAuthorMapper.selectByExample(utsAuthorExample);
        if (utsAuthors.size() > 0){
            UtsAuthorDto utsAuthorDto = new UtsAuthorDto();
            utsAuthorDto.setUtsAuthor(utsAuthors.get(0));
            return utsAuthorDto;
        }
        return null;
    }
}
