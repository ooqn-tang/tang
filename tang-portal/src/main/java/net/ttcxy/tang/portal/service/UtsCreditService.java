package net.ttcxy.tang.portal.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.model.PtsCredit;
import net.ttcxy.tang.portal.mapper.PtsCreditMapper;
import net.ttcxy.tang.portal.mapper.dao.PtsCreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtsCreditService {

    @Autowired
    private PtsCreditMapper creditList;

    @Autowired
    private PtsCreditDao creditDao;

    public void insert(Integer type) {
        String id = CurrentUtil.id();
        if (id == null){
            return;
        }
        try{
            PtsCredit like = new PtsCredit();
            like.setLikeId(IdUtil.objectId());
            like.setAuthorId(id);
            like.setValue(1);
            like.setType(type);
            like.setCreateDate(DateUtil.date());
            like.setCreateTime(DateUtil.date());
            creditList.insert(like);
        }catch (Exception ignored){}
    }

    public Integer selectCreditValue(String currentId) {
        return creditDao.selectCreditValue(currentId);
    }

    public PageInfo<PtsCredit> selectCreditList(String currentId) {
        PageHelper.startPage(1, 80);
        List<PtsCredit> creditList = this.creditList.selectByExample(null);
        return new PageInfo<>(creditList);
    }
}
