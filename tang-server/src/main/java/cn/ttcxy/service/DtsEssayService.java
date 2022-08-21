package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.mapper.DtsEssayMapper;
import cn.ttcxy.mapper.dao.DtsEssayDao;

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

    public PageInfo<DtsEssayDto> select(Integer page){
        PageHelper.startPage(page, 30);
        return new PageInfo<>(essayDao.select());
    }
}
