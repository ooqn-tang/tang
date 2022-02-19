package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.entity.model.DtsLike;
import net.ttcxy.tang.portal.entity.model.DtsLikeExample;
import net.ttcxy.tang.portal.mapper.DtsLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsLikeService {

    @Autowired
    private DtsLikeMapper likeMapper;

    public int insert(DtsLike praise) {
        try{
            return likeMapper.insert(praise);
        }catch (DuplicateKeyException e){
            return 1;
        }
    }

    /**
     * 返回记录的行数
     */
    public int select(String authorId,String dataId){
        DtsLikeExample likeExample = new DtsLikeExample();
        likeExample.createCriteria()
                .andAuthorIdEqualTo(authorId)
                .andDataIdEqualTo(dataId);
        List<DtsLike> dtsLikes = likeMapper.selectByExample(likeExample);
        return dtsLikes.size();
    }

    public int delete(String authorId,String dataId) {
        DtsLikeExample likeExample = new DtsLikeExample();
        likeExample.createCriteria().andAuthorIdEqualTo(authorId).andDataIdEqualTo(dataId);
        return likeMapper.deleteByExample(likeExample);
    }
}
