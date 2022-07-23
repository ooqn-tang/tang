package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.mapper.dao.DtsEssayDao;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.mapper.DtsEssayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsEssayService {

    @Autowired
    private DtsEssayMapper essayMapper;

    @Autowired
    private DtsEssayDao essayDao;


    public Integer insert(DtsEssay dynamic){
        dynamic.setEssayId(IdUtil.objectId());
        dynamic.setCreateTime(DateUtil.date());
        return essayMapper.insertSelective(dynamic);
    }

    public Integer delete(String authorId){
        return essayMapper.deleteByPrimaryKey(authorId);
    }

    public List<DtsEssayDto> select(String authorId, String type){
        return essayDao.select(authorId,type);
    }

    public Object selectEssay(String authorId, String type) {
        return essayDao.select(authorId,type);
    }
}
