package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.dao.dsl.UtsFansDsl;
import cn.ttcxy.dao.repository.UtsFansRepository;
import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsFans;

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

    
    public Page<UtsFansDto> selectFansList(String authorId,Pageable pageable){
        return fansDsl.selectFansList(authorId,pageable);
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
