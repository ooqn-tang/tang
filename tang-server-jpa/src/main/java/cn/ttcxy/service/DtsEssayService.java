package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.mapper.dsl.DtsEssayDsl;
import cn.ttcxy.mapper.repository.DtsEssayRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsEssayService {

    @Autowired
    private DtsEssayRepository essayRepository;

    @Autowired
    private DtsEssayDsl essayDsl;


    public DtsEssay insert(DtsEssay dynamic){
        dynamic.setEssayId(IdUtil.objectId());
        dynamic.setCreateTime(DateUtil.date());
        return essayRepository.save(dynamic);
    }

    public void delete(String authorId){
        essayRepository.deleteById(authorId);
    }

    public PageInfo<DtsEssayDto> select(Integer page){
        PageHelper.startPage(page, 30);
        return new PageInfo<>(essayDsl.select());
    }
}
