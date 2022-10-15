package cn.ttcxy.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsFans;
import cn.ttcxy.mapper.dsl.UtsFansDsl;
import cn.ttcxy.mapper.repository.UtsFansRepository;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 粉丝相关服务
 */
@Service
public class UtsFansService {

    @Autowired
    private UtsFansDsl fansDsl;

    @Autowired
    private UtsFansRepository fansRepository;

    @Autowired
    private UtsAuthorService authorService;

    
    public PageInfo<UtsFansDto> selectFansList(String authorId){
        return new PageInfo<>(fansDsl.selectFansList(authorId));
    }

    
    public UtsFans insertFans(UtsFans fans) {
        fans.setCreateDate(DateTime.now());
        fans.setFansId(IdUtil.objectId());
        return fansRepository.save(fans);
    }

    
    public int deleteFans(String fansName,String authorId){
        UtsAuthor author = authorService.selectAuthorByName(fansName);
        if (author != null){
            return fansRepository.deleteByBeAuthorIdAndAuthorId(author.getAuthorId(),authorId);
        }
        return 0;
    }

    
    public Long isFans(String authorId, String beAuthorId) {
        return fansDsl.isFans(authorId,beAuthorId);
    }
}
