package net.ttcxy.tang.portal.service;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsVideoDto;
import net.ttcxy.tang.portal.entity.model.DtsVideo;
import net.ttcxy.tang.portal.entity.model.DtsVideoClass;
import net.ttcxy.tang.portal.entity.model.DtsVisit;
import net.ttcxy.tang.portal.mapper.DtsVideoClassMapper;
import net.ttcxy.tang.portal.mapper.DtsVideoMapper;
import net.ttcxy.tang.portal.mapper.DtsVisitMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsVideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DtsVisitService {

    @Autowired
    private DtsVisitMapper visitMapper;

    public void insertVisit(String dataId,String authorId){
        String objectId = IdUtil.objectId();
        DtsVisit visit = new DtsVisit();
        visit.setVisitId(objectId);
        visit.setCreateDate(new Date());
        visit.setAuthorId(authorId);
        visit.setDataId(dataId);
        try{
            visitMapper.insertSelective(visit);
        }catch (Exception ignored){}

    }
}
